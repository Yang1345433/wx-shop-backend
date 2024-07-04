package yangcdtu.cn.wxshop.vo.address;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressVO {
    private Long id;
    private String detailedAddress;
    private String mobile;
    private String name;
    private Boolean isDefault;
}
