package yangcdtu.cn.wxshop.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import yangcdtu.cn.wxshop.common.utils.MinioService;
import yangcdtu.cn.wxshop.dto.brand.BrandPageQuery;
import yangcdtu.cn.wxshop.entity.Brand;
import yangcdtu.cn.wxshop.enums.MinioBucketEnum;
import yangcdtu.cn.wxshop.mapper.BrandMapper;
import yangcdtu.cn.wxshop.service.BrandService;
import yangcdtu.cn.wxshop.vo.brand.BrandDetailVO;
import yangcdtu.cn.wxshop.vo.brand.BrandPage;
import yangcdtu.cn.wxshop.vo.brand.BrandVO;

@Service
@AllArgsConstructor
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements BrandService {
    private final MinioService minioService;
    @Override
    public BrandPage getBrandList(BrandPageQuery query) {
        Page<Brand> page = this.page(Page.of(query.getPage(), query.getSize()));

        return new BrandPage(page.getRecords().stream().map(this::toBrandVO).toList(), page.getPages());
    }

    @Override
    public BrandDetailVO getDetail(Long id) {
        return toBrandDetailVO(this.getById(id));
    }

    private BrandDetailVO toBrandDetailVO(Brand brand) {
        return new BrandDetailVO(
                brand.getDescription(),
                minioService.getUrlForDownload(MinioBucketEnum.BRAND.getCode(), brand.getPicUrl())
        );
    }

    private BrandVO toBrandVO(Brand brand) {
        return new BrandVO(
                brand.getId(),
                brand.getName(),
                minioService.getUrlForDownload(MinioBucketEnum.BRAND.getCode(), brand.getPicUrl())
        );
    }
}
