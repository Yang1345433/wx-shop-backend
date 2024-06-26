package yangcdtu.cn.wxshop.Handler;

import com.baomidou.mybatisplus.extension.handlers.AbstractJsonTypeHandler;
import org.springframework.stereotype.Component;
import yangcdtu.cn.wxshop.common.utils.JsonUtils;
import yangcdtu.cn.wxshop.enums.RoleEnum;

import java.util.List;

@Component
public class RoleEnumListHandler extends AbstractJsonTypeHandler<List<RoleEnum>> {
    @Override
    protected List<RoleEnum> parse(String json) {
        if (json == null) return List.of();
        return JsonUtils.parseArray(json, RoleEnum.class);
    }

    @Override
    protected String toJson(List<RoleEnum> obj) {
        if (obj == null) obj = List.of();
        return JsonUtils.toJsonString(obj);
    }
}
