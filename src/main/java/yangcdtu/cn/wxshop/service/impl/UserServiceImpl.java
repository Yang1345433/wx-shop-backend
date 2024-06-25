package yangcdtu.cn.wxshop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import yangcdtu.cn.wxshop.entity.User;
import yangcdtu.cn.wxshop.mapper.UserMapper;
import yangcdtu.cn.wxshop.service.UserService;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
