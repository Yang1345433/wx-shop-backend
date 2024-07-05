package yangcdtu.cn.wxshop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import yangcdtu.cn.wxshop.entity.Cart;
import yangcdtu.cn.wxshop.vo.cart.CartGoodsVO;
import yangcdtu.cn.wxshop.vo.cart.CartTotalVO;

import java.util.List;

public interface CartService extends IService<Cart> {
    CartTotalVO getUserTotal(Long userId);
    List<CartGoodsVO> getCartGoodsByUser(Long userId);
    void checkedCartByUser(Long userId, List<Long> productIds, Boolean isChecked);

    void updateNumber(Long cartId, Integer number);
}
