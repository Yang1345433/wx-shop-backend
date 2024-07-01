package yangcdtu.cn.wxshop.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yangcdtu.cn.wxshop.dto.groupon.GrouponPageQuery;
import yangcdtu.cn.wxshop.service.GrouponService;
import yangcdtu.cn.wxshop.vo.groupon.GrouponPageVO;

@Tag(name = "团购")
@RestController
@RequestMapping("groupon")
@AllArgsConstructor
public class GrouponController {
    private final GrouponService grouponService;
    @GetMapping("list")
    @Operation(summary = "列表")
    public GrouponPageVO getGrouponList(@ParameterObject GrouponPageQuery query) {
        return grouponService.page(query);
    }
}
