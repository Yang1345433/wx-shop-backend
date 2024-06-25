package yangcdtu.cn.wxshop.common.utils;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MinioServiceTest {
    @Autowired
    private MinioService minioService;

    @Test
    public void getUrlForUploadTest() {
        String url = minioService.getUrlForUpload("test", "test.json");

        System.out.println(url);
    }

    @Test
    public void getUrlForDownloadTest() {
        String url = minioService.getUrlForDownload("temp", "temp.xlsx");

        System.out.println(url);
    }
}
