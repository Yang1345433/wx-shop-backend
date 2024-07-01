package yangcdtu.cn.wxshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import yangcdtu.cn.wxshop.common.utils.MinioService;
import yangcdtu.cn.wxshop.entity.Category;
import yangcdtu.cn.wxshop.enums.MinioBucketEnum;
import yangcdtu.cn.wxshop.mapper.CategoryMapper;
import yangcdtu.cn.wxshop.service.CategoryService;
import yangcdtu.cn.wxshop.vo.catalog.CatalogCurrentVO;
import yangcdtu.cn.wxshop.vo.catalog.CatalogIndexVO;
import yangcdtu.cn.wxshop.vo.catalog.CurrentCategoryVO;
import yangcdtu.cn.wxshop.vo.catalog.SubCategoryVO;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
    private final MinioService minioService;
    @Override
    public CatalogIndexVO getCatalogIndex() {
        List<Category> categories = this.list(
                new LambdaQueryWrapper<Category>()
                        .eq(Category::getParentId, 0L)
        );

        Category firstCategory = categories.get(0);

        return new CatalogIndexVO(
                categories.stream().map(Category::toVO).toList(),
                this.toCurrentCategoryVO(firstCategory),
                this.list(
                        new LambdaQueryWrapper<Category>()
                                .eq(Category::getParentId, firstCategory.getId())
                ).stream().map(this::toSubCategoryVO).toList()
        );
    }

    @Override
    public CatalogCurrentVO getCurrentCatalog(Long id) {
        Category category = this.getById(id);

        return new CatalogCurrentVO(
                this.toCurrentCategoryVO(category),
                this.list(
                        new LambdaQueryWrapper<Category>()
                                .eq(Category::getParentId, category.getId())
                ).stream().map(this::toSubCategoryVO).toList()
        );
    }

    private CurrentCategoryVO toCurrentCategoryVO(Category category) {
        return new CurrentCategoryVO(
                category.getId(),
                minioService.getUrlForDownload(MinioBucketEnum.CATEGORY.getCode(), category.getId().toString() + category.getPicUrl()),
                category.getFrontName(),
                category.getName()
        );
    }

    private SubCategoryVO toSubCategoryVO(Category category) {
        return new SubCategoryVO(
                category.getId(),
                minioService.getUrlForDownload(MinioBucketEnum.CATEGORY.getCode(), category.getId().toString() + category.getPicUrl()),
                category.getName()
        );
    }
}
