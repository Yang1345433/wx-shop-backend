package yangcdtu.cn.wxshop.handler;

import com.baomidou.mybatisplus.extension.handlers.AbstractJsonTypeHandler;
import org.springframework.stereotype.Component;
import yangcdtu.cn.wxshop.bo.CommentPicsBO;
import yangcdtu.cn.wxshop.common.utils.JsonUtils;

@Component
public class CommentPicsHandler extends AbstractJsonTypeHandler<CommentPicsBO> {
    @Override
    protected CommentPicsBO parse(String json) {
        return JsonUtils.parseObject(json, CommentPicsBO.class);
    }

    @Override
    protected String toJson(CommentPicsBO obj) {
        return JsonUtils.toJsonString(obj);
    }
}
