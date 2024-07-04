package yangcdtu.cn.wxshop.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import yangcdtu.cn.wxshop.enums.RegionType;

@TableName("region")
@Data
@AllArgsConstructor
public class Region {
    private Long id;
    private Long pid;
    private String name;
    private RegionType type;
}
