package yangcdtu.cn.wxshop.vo.catalog;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CurrentCategoryVO {
    private Long id;
    private String picUrl;
    private String frontName;
    private String name;
}
