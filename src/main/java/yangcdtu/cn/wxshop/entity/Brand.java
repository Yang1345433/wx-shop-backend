package yangcdtu.cn.wxshop.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

@TableName("brand")
@Data
@AllArgsConstructor
public class Brand {
    private Long id;
    private String name;
    private String picUrl;
    private String description;
}
