package yangcdtu.cn.wxshop.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsOtherInfoBO {
    private List<String> gallery;
    private List<AttributeBO> attribute;
    private List<IssueBO> issue;
}
