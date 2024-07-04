package yangcdtu.cn.wxshop.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
@TableName("address")
@Data
@AllArgsConstructor
public class Address {
    private Long id;
    private Long userId;
    private String address;
    private Long provinceId;
    private Long cityId;
    private Long areaId;
    private String mobile;
    private String name;
    private Boolean isDefault;
}
