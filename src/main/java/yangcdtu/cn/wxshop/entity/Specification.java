package yangcdtu.cn.wxshop.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

@TableName("specification")
@Data
@AllArgsConstructor
public class Specification {
    private Long id;
    private Long goodsId;
    private String value;
    private String spec;
}
