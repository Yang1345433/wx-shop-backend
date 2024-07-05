package yangcdtu.cn.wxshop.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

@TableName("cart")
@Data
@AllArgsConstructor
public class Cart {
    private Long id;
    private Long userId;
    private Boolean checked;
    private Long productId;
    private Long number;
}
