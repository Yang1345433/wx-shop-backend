package yangcdtu.cn.wxshop.dto.order;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderListQuery {
    private Integer showType;
    private Long page;
    private Long size;
}
