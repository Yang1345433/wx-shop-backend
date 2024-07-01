package yangcdtu.cn.wxshop.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import yangcdtu.cn.wxshop.common.utils.MinioService;
import yangcdtu.cn.wxshop.entity.Goods;
import yangcdtu.cn.wxshop.entity.Groupon;
import yangcdtu.cn.wxshop.enums.MinioBucketEnum;
import yangcdtu.cn.wxshop.service.GoodsService;
import yangcdtu.cn.wxshop.service.GrouponService;
import yangcdtu.cn.wxshop.service.IndexService;
import yangcdtu.cn.wxshop.vo.home.GoodsVO;
import yangcdtu.cn.wxshop.vo.home.GrouponVO;

import java.util.List;

@Service
@AllArgsConstructor
public class IndexServiceImpl implements IndexService {
    private final GrouponService grouponService;
    private final GoodsService goodsService;
    private final MinioService minioService;


    @Override
    public List<GrouponVO> grouponList() {
        return grouponService.list().stream().map(item -> this.toGrouponVO(
                item,
                toGoodsVO(goodsService.getById(item.getGoodsId()))
        )).toList();
    }

    private GrouponVO toGrouponVO(Groupon groupon, GoodsVO goods) {
        return new GrouponVO(
                groupon.getId(),
                groupon.getGrouponMember(),
                groupon.getGrouponPrice(),
                goods
        );
    }

    private GoodsVO toGoodsVO(Goods goods) {
        return new GoodsVO(
                goods.getId(),
                minioService.getUrlForDownload(MinioBucketEnum.GOODS.getCode(), goods.getId().toString() + goods.getPicUrl()),
                goods.getName(),
                goods.getBrief(),
                goods.getCounterPrice()
        );
    }
}
