package yangcdtu.cn.wxshop.vo.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserIndexOrderVO {
    private int unpaid;
    private int unship;
    private int unrecv;
    private int uncomment;
}
