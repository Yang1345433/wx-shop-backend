package yangcdtu.cn.wxshop.dto.groupon;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GrouponPageQuery {
    private Long page;
    private Long size;
}
