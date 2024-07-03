package yangcdtu.cn.wxshop.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IssueBO {
    private String question;
    private String answer;
}
