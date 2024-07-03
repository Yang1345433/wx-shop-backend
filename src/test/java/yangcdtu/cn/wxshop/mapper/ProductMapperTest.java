package yangcdtu.cn.wxshop.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import yangcdtu.cn.wxshop.entity.Product;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class ProductMapperTest {
    @Autowired
    private ProductMapper productMapper;

    @Test
    public void saveProducts() {
        List.of(
                new Product(null, 1L, BigDecimal.valueOf(16999.00), "16G,512G", 5L),
                new Product(null, 1L, BigDecimal.valueOf(19999.00), "32G,512G", 5L),
                new Product(null, 1L, BigDecimal.valueOf(18999.00), "16G,1T", 5L),
                new Product(null, 1L, BigDecimal.valueOf(21999.00), "32G,1T", 5L),
                new Product(null, 2L, BigDecimal.valueOf(19999.00), "16G,512G", 5L),
                new Product(null, 2L, BigDecimal.valueOf(21999.00), "32G,512G", 5L),
                new Product(null, 2L, BigDecimal.valueOf(21999.00), "16G,1T", 5L),
                new Product(null, 2L, BigDecimal.valueOf(23999.00), "32G,1T", 5L)
        ).forEach(item -> productMapper.insert(item));
    }
}
