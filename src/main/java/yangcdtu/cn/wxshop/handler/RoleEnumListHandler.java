package yangcdtu.cn.wxshop.handler;

import com.baomidou.mybatisplus.extension.handlers.AbstractJsonTypeHandler;
import org.springframework.stereotype.Component;
import yangcdtu.cn.wxshop.common.utils.JsonUtils;
import yangcdtu.cn.wxshop.enums.RoleEnum;

import java.util.Collections;
import java.util.List;
@Component
public class RoleEnumListHandler extends AbstractJsonTypeHandler<List<RoleEnum>> {
    @Override
    protected List<RoleEnum> parse(String json) {
        if (json == null) return Collections.emptyList();
        return JsonUtils.parseArray(json, RoleEnum.class);
    }

    @Override
    protected String toJson(List<RoleEnum> obj) {
        return JsonUtils.toJsonString(obj != null ? obj : Collections.emptyList());
    }
}
