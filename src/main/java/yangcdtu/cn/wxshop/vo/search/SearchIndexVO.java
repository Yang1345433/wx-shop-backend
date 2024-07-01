package yangcdtu.cn.wxshop.vo.search;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class SearchIndexVO {
    private List<KeywordVO> historyKeywordList;
    private KeywordVO defaultKeyword;
    private List<KeywordVO> hotKeywordList;
}
