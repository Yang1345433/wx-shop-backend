package yangcdtu.cn.wxshop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import yangcdtu.cn.wxshop.entity.User;
import yangcdtu.cn.wxshop.vo.user.UserIndexVO;

public interface UserService extends IService<User> {
    UserIndexVO getUserIndex();
}
