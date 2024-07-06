package yangcdtu.cn.wxshop.handler;

import com.baomidou.mybatisplus.extension.handlers.AbstractJsonTypeHandler;
import org.springframework.stereotype.Component;
import yangcdtu.cn.wxshop.bo.OrderOtherInfoBO;
import yangcdtu.cn.wxshop.common.utils.JsonUtils;

@Component
public class OrderOtherInfoHandler extends AbstractJsonTypeHandler<OrderOtherInfoBO> {
    @Override
    protected OrderOtherInfoBO parse(String json) {
        return JsonUtils.parseObject(json, OrderOtherInfoBO.class);
    }

    @Override
    protected String toJson(OrderOtherInfoBO obj) {
        return JsonUtils.toJsonString(obj);
    }
}
