package yangcdtu.cn.wxshop.api.amap;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import yangcdtu.cn.wxshop.api.amap.pojo.AmapDistrict;

@SpringBootTest
public class AmapApiServiceTest {
    @Autowired
    private AmapApiService apiService;

    @Test
    public void getProvinces() {
        for (AmapDistrict province : apiService.getAmapProvinces()) {
            System.out.println(province.getAdcode() + " : " + province.getName() + province.getDistricts());
        }
    }

    @Test
    public void getCities() {
        for (AmapDistrict city : apiService.getAmapCity("浙江")) {
            System.out.println(city.getAdcode() + " : " + city.getName());
        }
    }

    @Test
    public void getArea() {
        for (AmapDistrict city : apiService.getAmapArea("丽水市")) {
            System.out.println(city.getAdcode() + " : " + city.getName());
        }
    }
}
