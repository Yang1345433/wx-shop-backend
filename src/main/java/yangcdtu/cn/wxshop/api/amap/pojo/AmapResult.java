package yangcdtu.cn.wxshop.api.amap.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AmapResult {
    private Integer status;
    private String info;
    private String infoCode;
    private AmapSuggestion suggestion;
    private List<AmapDistrict> districts;
}
