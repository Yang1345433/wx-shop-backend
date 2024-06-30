package yangcdtu.cn.wxshop.vo.home;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class TopicVO {
    private Long id;
    private String picUrl;
    private String title;
    private BigDecimal price;
    private String subtitle;
}
