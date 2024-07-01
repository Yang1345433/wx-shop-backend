package yangcdtu.cn.wxshop.vo.groupon;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GrouponPageVO {
    private Long count;
    private List<GrouponVO> data;
}
