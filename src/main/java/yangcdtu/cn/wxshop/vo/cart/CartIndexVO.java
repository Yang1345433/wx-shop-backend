package yangcdtu.cn.wxshop.vo.cart;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CartIndexVO {
    private Integer isMultiOrderModel;
    private CartTotalVO cartTotal;
    private List<CartGoodsVO> cartList;
}
