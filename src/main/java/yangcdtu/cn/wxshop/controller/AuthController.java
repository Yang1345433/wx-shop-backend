package yangcdtu.cn.wxshop.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yangcdtu.cn.wxshop.common.exception.ServerException;
import yangcdtu.cn.wxshop.dto.auth.LoginByPasswordDTO;
import yangcdtu.cn.wxshop.dto.auth.LoginByWeiXinDTO;
import yangcdtu.cn.wxshop.enums.UserLevelEnum;
import yangcdtu.cn.wxshop.security.TokenStoreCache;
import yangcdtu.cn.wxshop.security.TokenUtils;
import yangcdtu.cn.wxshop.security.UserDetail;
import yangcdtu.cn.wxshop.vo.auth.TokenVO;
import yangcdtu.cn.wxshop.vo.auth.UserInfoVO;

import java.time.LocalDate;
import java.util.List;

@Tag(name = "认证")
@RestController
@RequestMapping("auth")
@AllArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final TokenStoreCache tokenStoreCache;
    @PostMapping("login/password")
    @Operation(summary = "登陆", description = "账号密码登陆")
    public TokenVO loginByPassword(
            @RequestBody LoginByPasswordDTO login
    ) {
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(login.getPhone(), login.getPassword())
            );
        } catch (BadCredentialsException e){
            throw new ServerException("账户或密码错误");
        }
        UserDetail user = (UserDetail) authentication.getPrincipal();
        String accessToken = TokenUtils.generator();
        tokenStoreCache.saveUser(accessToken, user);
        return new TokenVO(
                accessToken,
                new UserInfoVO(
                        "/static/images/avatar.png",
                        user.getName(),
                        user.getId(),
                        UserLevelEnum.LEVEL_2.getCode(),
                        UserLevelEnum.LEVEL_2.getDesc(),
                        LocalDate.now().toString(),
                        user.getUsername()
                )
        );
    }

    @PostMapping("login_by_weixin")
    @Operation(summary = "微信登陆")
    public TokenVO loginByWeiXin(@RequestBody LoginByWeiXinDTO account) {
        String accessToken = TokenUtils.generator();
        UserDetail userDetail = new UserDetail(null, account.getUserInfo().getNickName(), null, null, List.of());
        tokenStoreCache.saveUser(accessToken, userDetail);
        return new TokenVO(
                accessToken,
                new UserInfoVO(
                        account.getUserInfo().getAvatarUrl(),
                        userDetail.getName(),
                        0L,
                        UserLevelEnum.LEVEL_1.getCode(),
                        UserLevelEnum.LEVEL_1.getDesc(),
                        LocalDate.now().toString(),
                        null
                )
        );
    }

    @PostMapping("logout")
    @Operation(summary = "登出")
    public void logout(HttpServletRequest request) {
        tokenStoreCache.deleteUser(TokenUtils.getAccessToken(request));
    }
}
