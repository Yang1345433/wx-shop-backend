package yangcdtu.cn.wxshop.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import yangcdtu.cn.wxshop.common.exception.ServerException;

@Getter
@AllArgsConstructor
public enum OrderStatus {
    DUE("待付款", 1),
    SENT("待发货", 2),
    RECEIVE("待收货", 3),
    COMMENT("待评价", 4);
    private final String description;
    private final Integer showType;
    public static OrderStatus byShowType(Integer showType) {
        if (Integer.valueOf(0).equals(showType)) return null;
        for (OrderStatus item : OrderStatus.values()) {
            if (item.showType.equals(showType)) {
                return item;
            }
        }
        throw new ServerException("order status show type wrong");
    }
}
