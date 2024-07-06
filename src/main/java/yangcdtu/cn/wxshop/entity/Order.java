package yangcdtu.cn.wxshop.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import yangcdtu.cn.wxshop.bo.OrderOtherInfoBO;
import yangcdtu.cn.wxshop.enums.OrderStatus;

@TableName("wx_order")
@Data
@AllArgsConstructor
public class Order {
    private Long id;
    private Long userId;
    private String orderSn;
    private String addTime;
    private String consignee;
    private String mobile;
    private String address;
    private OrderStatus status;
    private OrderOtherInfoBO otherInfo;
}
