package yangcdtu.cn.wxshop.vo.region;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegionVO {
    private Long id;
    private Long pid;
    private String name;
    private Integer type;
    private Boolean selected;
}
