package yangcdtu.cn.wxshop.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
                        "head.png",
                        "Macbook pro 14英寸",
                        "搭载M3 pro MAX芯片的最新Macbook pro",
                        BigDecimal.valueOf(16999.99)
                ),
                new Goods(
                        null,
                        "head.png",
                        "Macbook pro 16英寸",
                        "搭载M3 pro MAX芯片的最新Macbook pro",
                        BigDecimal.valueOf(19999.99)
                )
        );

        goodsService.saveBatch(goodsList);
    }
}
