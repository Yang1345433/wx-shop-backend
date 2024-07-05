package yangcdtu.cn.wxshop.dto.cart;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CartCheckedDTO {
    private Boolean isChecked;
    private List<Long> productIds;
}
