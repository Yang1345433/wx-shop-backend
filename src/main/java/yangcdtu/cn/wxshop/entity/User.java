package yangcdtu.cn.wxshop.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

@TableName("user")
@Data
@Builder
public class User {
    private Long id;
    private String name;
    private String phone;
}
