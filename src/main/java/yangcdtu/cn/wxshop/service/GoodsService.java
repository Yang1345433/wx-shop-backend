package yangcdtu.cn.wxshop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import yangcdtu.cn.wxshop.dto.goods.GoodListQuery;
import yangcdtu.cn.wxshop.entity.Goods;
import yangcdtu.cn.wxshop.vo.goods.GoodsDetailVO;
import yangcdtu.cn.wxshop.vo.goods.GoodsPage;

public interface GoodsService extends IService<Goods> {
    GoodsPage getGoodsPageByCategory(GoodListQuery query);
    GoodsDetailVO getGoodsDetail(Long id);
}
