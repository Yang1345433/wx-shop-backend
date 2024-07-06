package yangcdtu.cn.wxshop.controller;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;
import yangcdtu.cn.wxshop.dto.order.OrderListQuery;
import yangcdtu.cn.wxshop.dto.order.OrderPrepayDTO;
import yangcdtu.cn.wxshop.dto.order.OrderSubmitDTO;
import yangcdtu.cn.wxshop.entity.Order;
import yangcdtu.cn.wxshop.enums.OrderStatus;
import yangcdtu.cn.wxshop.security.SecurityUser;
import yangcdtu.cn.wxshop.service.AddressService;
import yangcdtu.cn.wxshop.service.OrderService;
import yangcdtu.cn.wxshop.vo.order.OrderDetailVO;
import yangcdtu.cn.wxshop.vo.order.OrderPageVO;
import yangcdtu.cn.wxshop.vo.order.OrderSubmitVO;

@Tag(name = "订单")
@RestController
@RequestMapping("order")
@AllArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final AddressService addressService;

    @GetMapping("list")
    @Operation(summary = "列表")
    public OrderPageVO getOrderList(@ParameterObject OrderListQuery query) {
        return orderService.orderPage(query, SecurityUser.getUserId());
    }

    @GetMapping("detail")
    @Operation(summary = "详细")
    public OrderDetailVO getOrderDetail(@RequestParam Long orderId) {
        return orderService.getDetail(orderId);
    }

    @PostMapping("prepay")
    @Operation(summary = "付款")
    public void orderPrepay(@RequestBody OrderPrepayDTO prepay) {
        orderService.update(
                new LambdaUpdateWrapper<Order>()
                        .eq(Order::getId, prepay.getOrderId())
                        .set(Order::getStatus, OrderStatus.SENT)
        );
    }

    @PostMapping("confirm")
    @Operation(summary = "确认")
    public void orderConfirm(@RequestBody OrderPrepayDTO confirm) {
        orderService.update(
                new LambdaUpdateWrapper<Order>()
                        .eq(Order::getId, confirm.getOrderId())
                        .set(Order::getStatus, OrderStatus.COMMENT)
        );
    }

    @PostMapping("delete")
    @Operation(summary = "删除")
    public void deleteOrder(@RequestBody OrderPrepayDTO confirm) {
        orderService.removeById(confirm.getOrderId());
    }

    @PostMapping("submit")
    @Operation(summary = "提交")
    public OrderSubmitVO orderSubmit(@RequestBody OrderSubmitDTO submit) {
        return new OrderSubmitVO(orderService.saveOrder(submit, addressService.getDetail(submit.getAddressId())));
    }
}
