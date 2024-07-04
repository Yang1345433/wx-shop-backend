package yangcdtu.cn.wxshop.dto.address;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressSaveDTO {
    private Long id;
    private String address;
    private Long provinceId;
    private Long cityId;
    private Long areaId;
    private String name;
    private String mobile;
    private Boolean isDefault;
}
