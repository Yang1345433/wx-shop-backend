package yangcdtu.cn.wxshop.service;

import yangcdtu.cn.wxshop.vo.home.ChannelVO;
import yangcdtu.cn.wxshop.vo.home.GrouponVO;

import java.util.List;

public interface IndexService {
    List<GrouponVO> grouponList();

    List<ChannelVO> getIndexChannel();
}
