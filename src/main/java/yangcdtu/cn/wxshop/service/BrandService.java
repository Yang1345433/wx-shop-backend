package yangcdtu.cn.wxshop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import yangcdtu.cn.wxshop.dto.brand.BrandPageQuery;
import yangcdtu.cn.wxshop.entity.Brand;
import yangcdtu.cn.wxshop.vo.brand.BrandDetailVO;
import yangcdtu.cn.wxshop.vo.brand.BrandPage;

public interface BrandService extends IService<Brand> {
    BrandPage getBrandList(BrandPageQuery query);
    BrandDetailVO getDetail(Long id);
}
