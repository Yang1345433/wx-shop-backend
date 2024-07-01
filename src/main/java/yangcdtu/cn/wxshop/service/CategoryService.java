package yangcdtu.cn.wxshop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import yangcdtu.cn.wxshop.entity.Category;
import yangcdtu.cn.wxshop.vo.catalog.CatalogCurrentVO;
import yangcdtu.cn.wxshop.vo.catalog.CatalogIndexVO;

public interface CategoryService extends IService<Category> {
    CatalogIndexVO getCatalogIndex();
    CatalogCurrentVO getCurrentCatalog(Long id);
}
