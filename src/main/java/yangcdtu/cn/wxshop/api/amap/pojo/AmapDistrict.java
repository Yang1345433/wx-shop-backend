package yangcdtu.cn.wxshop.api.amap.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AmapDistrict {
    private String adcode;
    private String name;
    private String polyline;
    private String center;
    private String level;
    private List<AmapDistrict> districts;
}
