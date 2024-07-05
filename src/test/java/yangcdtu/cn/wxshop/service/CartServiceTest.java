package yangcdtu.cn.wxshop.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import yangcdtu.cn.wxshop.entity.Cart;

import java.util.List;

@SpringBootTest
public class CartServiceTest {
    @Autowired
    private CartService cartService;

    @Test
    public void saveCarts() {
        List<Cart> carts = List.of(
                new Cart(
                        null,
                        1L,
                        false,
                        1L,
                        2L
                ),
                new Cart(
                        null,
                        1L,
                        false,
                        2L,
                        2L
                )
        );

        cartService.saveBatch(carts);
    }
}
