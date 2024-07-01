package yangcdtu.cn.wxshop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import yangcdtu.cn.wxshop.dto.groupon.GrouponPageQuery;
import yangcdtu.cn.wxshop.entity.Groupon;
import yangcdtu.cn.wxshop.vo.groupon.GrouponPageVO;

public interface GrouponService extends IService<Groupon> {
    GrouponPageVO page(GrouponPageQuery query);
}
