package yangcdtu.cn.wxshop.vo.home;

import lombok.AllArgsConstructor;
import lombok.Data;
import yangcdtu.cn.wxshop.vo.article.ArticlesVO;

import java.util.List;

@Data
@AllArgsConstructor
public class HomeIndexInfoVO {
    private List<BannerVO> banner;
    private List<ChannelVO> channel;
    private List<ArticlesVO> articles;
    private List<GrouponVO> grouponList;
}
