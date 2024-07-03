package yangcdtu.cn.wxshop.vo.brand;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class BrandPage {
    private List<BrandVO> brandList;
    private Long totalPages;
}
