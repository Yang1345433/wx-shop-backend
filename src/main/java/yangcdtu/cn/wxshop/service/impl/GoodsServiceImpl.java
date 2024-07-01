package yangcdtu.cn.wxshop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import yangcdtu.cn.wxshop.entity.Goods;
import yangcdtu.cn.wxshop.mapper.GoodsMapper;
import yangcdtu.cn.wxshop.service.GoodsService;

@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {
}
