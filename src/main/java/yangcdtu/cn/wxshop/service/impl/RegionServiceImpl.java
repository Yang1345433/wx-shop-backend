package yangcdtu.cn.wxshop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import yangcdtu.cn.wxshop.entity.Region;
import yangcdtu.cn.wxshop.mapper.RegionMapper;
import yangcdtu.cn.wxshop.service.RegionService;

@Service
public class RegionServiceImpl extends ServiceImpl<RegionMapper, Region> implements RegionService {
}
