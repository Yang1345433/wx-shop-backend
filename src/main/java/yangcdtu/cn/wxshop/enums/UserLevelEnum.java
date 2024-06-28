package yangcdtu.cn.wxshop.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserLevelEnum {
    LEVEL_1(1, "普通会员"),
    LEVEL_2(2, "高级会员");
    private final int code;
    private final String desc;
}
