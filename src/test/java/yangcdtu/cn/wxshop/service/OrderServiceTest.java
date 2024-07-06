package yangcdtu.cn.wxshop.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import yangcdtu.cn.wxshop.bo.OrderGoodsBO;
import yangcdtu.cn.wxshop.bo.OrderOtherInfoBO;
import yangcdtu.cn.wxshop.entity.Order;
import yangcdtu.cn.wxshop.enums.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class OrderServiceTest {
    @Autowired
    private OrderService orderService;

    @Test
    public void saveOrders() {
        List<Order> orders = List.of(
                new Order(
                        null,
                        1L,
                        "1234567",
                        LocalDate.now().toString(),
                        "杨建明",
                        "18357894352",
                        "xxx地址",
                        OrderStatus.DUE,
                        new OrderOtherInfoBO(
                                List.of(
                                        new OrderGoodsBO(
                                                1L,
                                                "goods 1",
                                                "spec",
                                                1L,
                                                BigDecimal.valueOf(16900.00),
                                                0
                                        ),
                                        new OrderGoodsBO(
                                                2L,
                                                "goods 2",
                                                "spec",
                                                1L,
                                                BigDecimal.valueOf(19900.00),
                                                0
                                        )
                                ),
                                BigDecimal.valueOf(31999.00),
                                BigDecimal.valueOf(10),
                                BigDecimal.valueOf(100),
                                BigDecimal.valueOf(31909.00)
                        )
                ),
                new Order(
                        null,
                        1L,
                        "1234567",
                        LocalDate.now().toString(),
                        "杨建明",
                        "18357894352",
                        "xxx地址",
                        OrderStatus.COMMENT,
                        new OrderOtherInfoBO(
                                List.of(
                                        new OrderGoodsBO(
                                                1L,
                                                "goods 1",
                                                "spec",
                                                1L,
                                                BigDecimal.valueOf(16900.00),
                                                0
                                        ),
                                        new OrderGoodsBO(
                                                2L,
                                                "goods 2",
                                                "spec",
                                                1L,
                                                BigDecimal.valueOf(19900.00),
                                                0
                                        )
                                ),
                                BigDecimal.valueOf(31999.00),
                                BigDecimal.valueOf(10),
                                BigDecimal.valueOf(100),
                                BigDecimal.valueOf(31909.00)
                        )
                )
        );

        orderService.saveBatch(orders);
    }
}
