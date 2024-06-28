package yangcdtu.cn.wxshop.vo.home;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class HomeIndexInfoVO {
    private List<BannerVO> banner;
    private List<ChannelVO> channel;
}
