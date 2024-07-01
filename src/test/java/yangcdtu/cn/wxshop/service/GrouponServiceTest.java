package yangcdtu.cn.wxshop.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import yangcdtu.cn.wxshop.entity.Groupon;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class GrouponServiceTest {
    @Autowired
    private GrouponService grouponService;

    @Test
    public void saveGrouponList() {
        List<Groupon> grouponList = List.of(
                new Groupon(
                        null,
                        1L,
                        3,
                        BigDecimal.valueOf(12999.99)
                ),
                new Groupon(
                        null,
                        2L,
                        3,
                        BigDecimal.valueOf(16999.99)
                )
        );

        grouponService.saveBatch(grouponList);
    }
}
