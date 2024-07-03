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
import java.util.UUID;

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
                        "head.jpeg",
                        "Macbook pro 14英寸",
                        "搭载M3 pro MAX芯片的最新Macbook pro",
                        BigDecimal.valueOf(16999.99),
                        null,
                        "<h1>最新款Macbook pro</h1>",
                        new GoodsOtherInfoBO(
                                List.of(UUID.randomUUID() + "head.jpeg", UUID.randomUUID() + "head.jpeg"),
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
                        "head.jpeg",
                        "Macbook pro 14英寸",
                        "搭载M3 pro MAX芯片的最新Macbook pro",
                        BigDecimal.valueOf(19999.99),
                        null,
                        "<h1>最新款Macbook pro</h1>",
                        new GoodsOtherInfoBO(
                                List.of(UUID.randomUUID() + "head.jpeg", UUID.randomUUID() + "head.jpeg"),
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
    }

    @Test
    public void getGoods() {
        Goods goods = goodsService.getById(1);
        System.out.println(goods);
    }
}
