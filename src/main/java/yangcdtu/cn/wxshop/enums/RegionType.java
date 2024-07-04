package yangcdtu.cn.wxshop.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RegionType {
    PROVINCE(1, "省份"),
    CITY(2, "城市"),
    AREA(3, "区县");
    private final Integer code;
    private final String description;
}
