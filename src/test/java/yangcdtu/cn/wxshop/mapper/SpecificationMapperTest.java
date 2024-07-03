package yangcdtu.cn.wxshop.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import yangcdtu.cn.wxshop.entity.Specification;

import java.util.List;

@SpringBootTest
public class SpecificationMapperTest {
    @Autowired
    private SpecificationMapper specificationMapper;

    @Test
    public void saveSpecifications() {
        List.of(
                new Specification(null, 1L, "16G", "运行内存"),
                new Specification(null, 1L, "32G", "运行内存"),
                new Specification(null, 1L, "512G", "存储大小"),
                new Specification(null, 1L, "1T", "存储大小"),
                new Specification(null, 2L, "16G", "运行内存"),
                new Specification(null, 2L, "32G", "运行内存"),
                new Specification(null, 2L, "512G", "存储大小"),
                new Specification(null, 2L, "1T", "存储大小")
        ).forEach(item -> specificationMapper.insert(item));
    }
}
