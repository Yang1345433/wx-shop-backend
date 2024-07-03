package yangcdtu.cn.wxshop.dto.brand;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BrandPageQuery {
    private Long page;
    private Long size;
}
