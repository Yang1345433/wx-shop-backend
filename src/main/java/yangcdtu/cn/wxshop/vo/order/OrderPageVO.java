package yangcdtu.cn.wxshop.vo.order;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class OrderPageVO {
    private List<OrderVO> data;
    private Long totalPages;
}
