package yangcdtu.cn.wxshop.vo.address;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDetailVO {
    private Long id;
    private Long provinceId;
    private Long cityId;
    private Long areaId;
    private String address;
    private String mobile;
    private String name;
    private Boolean isDefault;
    private String provinceName;
    private String cityName;
    private String areaName;
}
