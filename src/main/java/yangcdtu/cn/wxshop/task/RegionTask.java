package yangcdtu.cn.wxshop.task;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yangcdtu.cn.wxshop.api.amap.AmapApiService;
import yangcdtu.cn.wxshop.api.amap.pojo.AmapDistrict;
import yangcdtu.cn.wxshop.entity.Region;
import yangcdtu.cn.wxshop.enums.RegionType;
import yangcdtu.cn.wxshop.service.RegionService;

import java.util.List;

@Service
@AllArgsConstructor
public class RegionTask {
    private final AmapApiService apiService;

    private final RegionService regionService;

    @Transactional
    public void saveRegion() {
        List<Region> provinces = apiService.getAmapProvinces().stream().map(item -> this.toRegion(item, 0L, RegionType.PROVINCE)).toList();
        regionService.saveBatch(provinces);

        provinces.forEach(province -> {
            List<Region> cities = apiService.getAmapCity(province.getName()).stream().map(item -> this.toRegion(item, province.getId(), RegionType.CITY)).toList();
            regionService.saveBatch(cities);

            cities.forEach(city -> {
                List<Region> areas = apiService.getAmapArea(city.getName()).stream().map(item -> this.toRegion(item, city.getId(), RegionType.AREA)).toList();
                regionService.saveBatch(areas);
            });
        });
    }

    private Region toRegion(AmapDistrict district, Long pid, RegionType type) {
        return new Region(null, pid, district.getName(), type);
    }
}
