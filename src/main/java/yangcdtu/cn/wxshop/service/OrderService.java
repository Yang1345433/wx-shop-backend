package yangcdtu.cn.wxshop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import yangcdtu.cn.wxshop.dto.order.OrderListQuery;
import yangcdtu.cn.wxshop.dto.order.OrderSubmitDTO;
import yangcdtu.cn.wxshop.entity.Order;
import yangcdtu.cn.wxshop.vo.address.AddressDetailVO;
import yangcdtu.cn.wxshop.vo.order.OrderDetailVO;
import yangcdtu.cn.wxshop.vo.order.OrderPageVO;

public interface OrderService extends IService<Order> {
    OrderPageVO orderPage(OrderListQuery query, Long userId);
    OrderDetailVO getDetail(Long id);
    Long saveOrder(OrderSubmitDTO submit, AddressDetailVO address);
}
