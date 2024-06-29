package yangcdtu.cn.wxshop.vo.goods;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class SpecificationVO {
    private List<SpecificationValueVO> valueList;
}
