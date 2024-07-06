package yangcdtu.cn.wxshop.vo.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserIndexOrderVO {
    private Long unpaid;
    private Long unship;
    private Long unrecv;
    private Long uncomment;
}
