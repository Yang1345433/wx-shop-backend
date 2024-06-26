package yangcdtu.cn.wxshop.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoleEnum {
    ADMIN("管理员"),
    BUSINESS("商家"),
    GUEST("客户");
    private final String description;
}
