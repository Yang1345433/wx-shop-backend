package yangcdtu.cn.wxshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import yangcdtu.cn.wxshop.entity.Order;
import yangcdtu.cn.wxshop.entity.User;
import yangcdtu.cn.wxshop.entity.UserCoupon;
import yangcdtu.cn.wxshop.enums.OrderStatus;
import yangcdtu.cn.wxshop.mapper.OrderMapper;
import yangcdtu.cn.wxshop.mapper.UserCouponMapper;
import yangcdtu.cn.wxshop.mapper.UserMapper;
import yangcdtu.cn.wxshop.security.SecurityUser;
import yangcdtu.cn.wxshop.service.UserService;
import yangcdtu.cn.wxshop.vo.user.UserIndexOrderVO;
import yangcdtu.cn.wxshop.vo.user.UserIndexVO;

@Service
@AllArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    private OrderMapper orderMapper;
    private UserCouponMapper userCouponMapper;
    @Override
    public UserIndexVO getUserIndex() {
        return new UserIndexVO(
                new UserIndexOrderVO(
                        orderMapper.selectCount(
                                new LambdaQueryWrapper<Order>()
                                        .eq(Order::getUserId, SecurityUser.getUserId())
                                        .eq(Order::getStatus, OrderStatus.DUE)
                        ),
                        orderMapper.selectCount(
                                new LambdaQueryWrapper<Order>()
                                        .eq(Order::getUserId, SecurityUser.getUserId())
                                        .eq(Order::getStatus, OrderStatus.SENT)
                        ),
                        orderMapper.selectCount(
                                new LambdaQueryWrapper<Order>()
                                        .eq(Order::getUserId, SecurityUser.getUserId())
                                        .eq(Order::getStatus, OrderStatus.RECEIVE)
                        ),
                        orderMapper.selectCount(
                                new LambdaQueryWrapper<Order>()
                                        .eq(Order::getUserId, SecurityUser.getUserId())
                                        .eq(Order::getStatus, OrderStatus.COMMENT)
                        )
                ),
                1L,
                1L,
                userCouponMapper.selectCount(
                        new LambdaQueryWrapper<UserCoupon>()
                                .eq(UserCoupon::getUserId, SecurityUser.getUserId())
                )
        );
    }
}
