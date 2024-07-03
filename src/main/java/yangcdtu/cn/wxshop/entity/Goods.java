package yangcdtu.cn.wxshop.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import yangcdtu.cn.wxshop.bo.GoodsOtherInfoBO;

import java.math.BigDecimal;

@TableName(value = "goods")
@Data
@AllArgsConstructor
public class Goods {
    private Long id;
    private Long categoryId;
    private String categoryName;
    private Long brandId;
    private String picUrl;
    private String name;
    private String brief;
    private BigDecimal retailPrice;
    private BigDecimal counterPrice;
    private String detail;
    private GoodsOtherInfoBO otherInfo;
}
