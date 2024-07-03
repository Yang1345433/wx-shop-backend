package yangcdtu.cn.wxshop.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import yangcdtu.cn.wxshop.bo.AttributeBO;
import yangcdtu.cn.wxshop.bo.GoodsOtherInfoBO;
import yangcdtu.cn.wxshop.bo.IssueBO;
import yangcdtu.cn.wxshop.entity.Goods;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class GoodsServiceTest {
    @Autowired
    private GoodsService goodsService;

    @Test
    public void saveGoodsList() {
        List<Goods> goodsList = List.of(
                new Goods(
                        null,
                        4L,
                        "电脑",
                        1L,
                        "head.jpeg",
                        "Macbook pro 14英寸",
                        "搭载M3 pro MAX芯片的最新Macbook pro",
                        BigDecimal.valueOf(16999.99),
                        null,
                        "<h1>最新款Macbook pro</h1>",
                        new GoodsOtherInfoBO(
                                List.of("3bf6d34e-e025-4dd6-b5bc-8953acfbe662head.jpeg", "12b679a0-157f-48a3-bdbd-dd08427606dfhead.jpeg"),
                                List.of(
                                        new AttributeBO("屏幕尺寸", "14英寸"),
                                        new AttributeBO("续航时间", "12小时"),
                                        new AttributeBO("芯片", "M3 MAX")
                                ),
                                List.of(
                                        new IssueBO(
                                                "为啥没有颜色选择？",
                                                "颜色只有一款"
                                        ),
                                        new IssueBO(
                                                "为啥没有16英寸",
                                                "16英寸请换一款商品"
                                        )
                                )
                        )
                ),
                new Goods(
                        null,
                        4L,
                        "电脑",
                        1L,
                        "head.jpeg",
                        "Macbook pro 14英寸",
                        "搭载M3 pro MAX芯片的最新Macbook pro",
                        BigDecimal.valueOf(19999.99),
                        null,
                        "<h1>最新款Macbook pro</h1>",
                        new GoodsOtherInfoBO(
                                List.of("c2ea2bd3-38f3-4a8a-b4bd-cd617b19687fhead.jpeg", "b30f0e80-132b-4ab1-ab8c-cb5a4a803f7chead.jpeg"),
                                List.of(
                                        new AttributeBO("屏幕尺寸", "16英寸"),
                                        new AttributeBO("续航时间", "24小时"),
                                        new AttributeBO("芯片", "M3 MAX")
                                ),
                                List.of(
                                        new IssueBO(
                                                "为啥没有颜色选择？",
                                                "颜色只有一款"
                                        ),
                                        new IssueBO(
                                                "为啥没有14英寸",
                                                "14英寸请换一款商品"
                                        )
                                )
                        )
                )
        );

        goodsService.saveBatch(goodsList);

        goodsList.forEach(item -> System.out.println(item.getOtherInfo().getGallery()));
    }

    @Test
    public void getGoods() {
        Goods goods = goodsService.getById(2);
        System.out.println(goods.getOtherInfo().getGallery());
    }
}
