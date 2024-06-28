package yangcdtu.cn.wxshop.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import yangcdtu.cn.wxshop.entity.User;
import yangcdtu.cn.wxshop.service.UserService;
import yangcdtu.cn.wxshop.vo.user.UserIndexVO;

@Tag(name = "用户")
@RestController
@RequestMapping("user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping
    @Operation(summary = "用户信息")
    public User userInfo(@RequestParam Long id) {
        return userService.getById(id);
    }

    @GetMapping("index")
    @Operation(summary = "用户index信息")
    public UserIndexVO userIndexInfo() {
        return userService.getUserIndex();
    }
}
