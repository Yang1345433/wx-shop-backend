package yangcdtu.cn.wxshop.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import yangcdtu.cn.wxshop.vo.groupon.GoodsVO;
import yangcdtu.cn.wxshop.vo.groupon.GrouponVO;

import java.math.BigDecimal;

@TableName("groupon")
@Data
@AllArgsConstructor
public class Groupon {
    private Long id;
    private Long goodsId;
    private Integer grouponMember;
    private BigDecimal grouponPrice;

    public GrouponVO toVO(GoodsVO goods) {
        return new GrouponVO(
                id,
                grouponMember,
                goods,
                grouponPrice
        );
    }
}
