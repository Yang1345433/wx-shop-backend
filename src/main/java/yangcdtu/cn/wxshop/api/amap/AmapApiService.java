package yangcdtu.cn.wxshop.api.amap;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import yangcdtu.cn.wxshop.api.amap.pojo.AmapDistrict;
import yangcdtu.cn.wxshop.api.amap.pojo.AmapResult;
import yangcdtu.cn.wxshop.common.exception.ServerException;

import java.util.List;

@Service
@AllArgsConstructor
public class AmapApiService {
    private final RestTemplate restTemplate;

    private final static String BASE_URL = "https://restapi.amap.com/v3/config/district?keywords=";
    private final static String KEY = "&key=e7bba6ebf1d8f3078c3f69d771ab1838";

    public List<AmapDistrict> getAmapProvinces() {
        String url = BASE_URL + KEY;

        return getResult(url).getDistricts().get(0).getDistricts();
    }

    public List<AmapDistrict> getAmapCity(String provinceName) {
        String url = BASE_URL + provinceName + KEY;

        return getResult(url).getDistricts().get(0).getDistricts();
    }

    public List<AmapDistrict> getAmapArea(String areaName) {
        String url = BASE_URL + areaName + KEY;

        return getResult(url).getDistricts().get(0).getDistricts();
    }

    private AmapResult getResult(String url) {
        AmapResult result = restTemplate.getForObject(url, AmapResult.class);

        if (result == null || result.getStatus() != 1) throw new ServerException("高德获取地址信息错误");

        return restTemplate.getForObject(url, AmapResult.class);
    }
}
