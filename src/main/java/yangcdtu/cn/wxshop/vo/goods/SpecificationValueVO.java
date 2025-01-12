package yangcdtu.cn.wxshop.vo.goods;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SpecificationValueVO {
    private Long id;
    private Boolean checked;
    private String value;
    private String specification;
}
