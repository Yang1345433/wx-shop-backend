package yangcdtu.cn.wxshop.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import yangcdtu.cn.wxshop.entity.Brand;

@SpringBootTest
public class BrandServiceTest {
    @Autowired
    private BrandService brandService;

    @Test
    public void saveBrand() {
        Brand brand = new Brand(null, "小米旗舰店", "iphone.png", "专买 苹果 产品的旗舰店");

        brandService.save(brand);
    }
}
