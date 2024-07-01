package yangcdtu.cn.wxshop.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@TableName("goods")
@Data
@AllArgsConstructor
public class Goods {
    private Long id;
    private String picUrl;
    private String name;
    private String brief;
    private BigDecimal counterPrice;
}
