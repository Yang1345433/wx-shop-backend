package yangcdtu.cn.wxshop.api.amap.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AmapSuggestion {
    private List<String> keywords;
    private List<String> cities;
}
