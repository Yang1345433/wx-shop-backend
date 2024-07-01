package yangcdtu.cn.wxshop.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import yangcdtu.cn.wxshop.common.utils.MinioService;
import yangcdtu.cn.wxshop.dto.groupon.GrouponPageQuery;
import yangcdtu.cn.wxshop.entity.Goods;
import yangcdtu.cn.wxshop.entity.Groupon;
import yangcdtu.cn.wxshop.enums.MinioBucketEnum;
import yangcdtu.cn.wxshop.mapper.GoodsMapper;
import yangcdtu.cn.wxshop.mapper.GrouponMapper;
import yangcdtu.cn.wxshop.service.GrouponService;
import yangcdtu.cn.wxshop.vo.groupon.GoodsVO;
import yangcdtu.cn.wxshop.vo.groupon.GrouponPageVO;
import yangcdtu.cn.wxshop.vo.groupon.GrouponVO;

import java.util.List;

@Service
@AllArgsConstructor
public class GrouponServiceImpl extends ServiceImpl<GrouponMapper, Groupon> implements GrouponService {
    private final GoodsMapper goodsMapper;
    private final MinioService minioService;
    @Override
    public GrouponPageVO page(GrouponPageQuery query) {
        Page<Groupon> grouponPage = this.page(Page.of(query.getPage(), query.getSize()));

        List<GrouponVO> grouponList = grouponPage.getRecords().stream().map(item -> item.toVO(this.goodsToVO(goodsMapper.selectById(item.getGoodsId())))).toList();

        return new GrouponPageVO(
                grouponPage.getTotal(),
                grouponList
        );
    }

    private GoodsVO goodsToVO(Goods goods) {
        return new GoodsVO(
                goods.getId(),
                minioService.getUrlForDownload(MinioBucketEnum.GOODS.getCode(), goods.getId().toString() + goods.getPicUrl()),
                goods.getName(),
                goods.getBrief(),
                goods.getCounterPrice()
        );
    }
}
