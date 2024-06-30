package yangcdtu.cn.wxshop.vo.home;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class FloorGoodsVO {
    private Long id;
    private String name;
    private List<FloorGoodsDetailVO> goodsList;
}
