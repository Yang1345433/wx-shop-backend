package yangcdtu.cn.wxshop.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@TableName("product")
@Data
@AllArgsConstructor
public class Product {
    private Long id;
    private Long goodsId;
    private BigDecimal price;
    private String specifications;
    private Long number;
}
