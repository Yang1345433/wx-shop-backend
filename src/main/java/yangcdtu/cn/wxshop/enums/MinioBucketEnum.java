package yangcdtu.cn.wxshop.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MinioBucketEnum {
    HOME_BANNER("homebanner", "首页轮播图"),
    HOME_CHANNEL("homechannel", "首页分类"),
    GOODS("goods", "商品"),
    CATEGORY("category", "分类"),
    CATEGORY_ICON("categoryicon", "分类图标"),
    COMMENT("comment", "评论图片"),
    BRAND("brand", "品牌");
    private final String code;
    private final String desc;
}
