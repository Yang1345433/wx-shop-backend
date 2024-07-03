package yangcdtu.cn.wxshop.handler;

import com.baomidou.mybatisplus.extension.handlers.AbstractJsonTypeHandler;
import org.springframework.stereotype.Component;
import yangcdtu.cn.wxshop.bo.GoodsOtherInfoBO;
import yangcdtu.cn.wxshop.common.utils.JsonUtils;

@Component
public class GoodsOtherInfoHandler extends AbstractJsonTypeHandler<GoodsOtherInfoBO> {
    @Override
    protected GoodsOtherInfoBO parse(String json) {
        return JsonUtils.parseObject(json, GoodsOtherInfoBO.class);
    }

    @Override
    protected String toJson(GoodsOtherInfoBO obj) {
        return JsonUtils.toJsonString(obj);
    }
}
