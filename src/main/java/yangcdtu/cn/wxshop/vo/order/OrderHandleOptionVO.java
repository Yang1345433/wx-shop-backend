package yangcdtu.cn.wxshop.vo.order;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderHandleOptionVO {
    private Boolean comment;
    private Boolean rebuy;
    private Boolean cancel;
    private Boolean pay;
    private Boolean confirm;
    private Boolean delete;
    private Boolean refund;
}
