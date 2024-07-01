package yangcdtu.cn.wxshop.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MinioBucketEnum {
    HOME_BANNER("homebanner", "首页轮播图"),
    HOME_CHANNEL("homechannel", "首页分类"),
    GOODS("goods", "商品"),
    CATEGORY("category", "分类");
    private final String code;
    private final String desc;
}
