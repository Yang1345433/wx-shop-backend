package yangcdtu.cn.wxshop.task;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RegionTaskTest {
    @Autowired
    private RegionTask regionTask;

    @Test
    public void saveRegions() {
        regionTask.saveRegion();
    }
}
