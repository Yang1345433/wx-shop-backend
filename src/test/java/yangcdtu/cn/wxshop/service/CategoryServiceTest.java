package yangcdtu.cn.wxshop.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import yangcdtu.cn.wxshop.entity.Category;

import java.util.List;

@SpringBootTest
public class CategoryServiceTest {
    @Autowired
    private CategoryService categoryService;

    @Test
    public void saveParentCategoryList() {
        List<Category> categoryList = List.of(
                new Category(
                        null,
                        0L,
                        "head.png",
                        "数码",
                        "数码产品"
                ),
                new Category(
                        null,
                        0L,
                        "head.png",
                        "电器",
                        "电器产品"
                ),
                new Category(
                        null,
                        0L,
                        "head.png",
                        "服装",
                        "服装产品"
                )
        );

        categoryService.saveBatch(categoryList);
    }

    @Test
    public void saveSubCategoryList() {
        List<Category> categoryList = List.of(
                new Category(
                        null,
                        3L,
                        "head.png",
                        "裤子",
                        "裤子"
                ),
                new Category(
                        null,
                        3L,
                        "head.png",
                        "衣服",
                        "衣服"
                )
        );

        categoryService.saveBatch(categoryList);
    }
}
