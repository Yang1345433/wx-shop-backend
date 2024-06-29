package yangcdtu.cn.wxshop.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yangcdtu.cn.wxshop.common.utils.MinioService;
import yangcdtu.cn.wxshop.dto.comment.CommentCountQuery;
import yangcdtu.cn.wxshop.dto.comment.CommentListQuery;
import yangcdtu.cn.wxshop.enums.MinioBucketEnum;
import yangcdtu.cn.wxshop.enums.UserLevelEnum;
import yangcdtu.cn.wxshop.vo.auth.UserInfoVO;
import yangcdtu.cn.wxshop.vo.comment.CommentCountVO;
import yangcdtu.cn.wxshop.vo.comment.CommentDetailVO;
import yangcdtu.cn.wxshop.vo.comment.CommentPage;

import java.util.List;

@Tag(name = "评论")
@RestController
@RequestMapping("comment")
@AllArgsConstructor
public class CommentController {
    private final MinioService minioService;
    @GetMapping("count")
    @Operation(summary = "评论数量")
    public CommentCountVO getCommentCount(@ParameterObject CommentCountQuery query) {
        System.out.println(query);
        return new CommentCountVO(2L, 2L);
    }

    @GetMapping("list")
    @Operation(summary = "列表")
    public CommentPage getCommentList(@ParameterObject CommentListQuery query) {
        System.out.println(query);
        return new CommentPage(
                2L,
                List.of(
                        new CommentDetailVO(
                                new UserInfoVO(
                                        minioService.getUrlForDownload(MinioBucketEnum.HOME_BANNER.getCode(), "head.png"),
                                        "comment nick name 1",
                                        1L,
                                        UserLevelEnum.LEVEL_1.getCode(),
                                        UserLevelEnum.LEVEL_1.getDesc(),
                                        "2024-06-28",
                                        "18357894352"
                                ),
                                "2024-06-27",
                                "comment 1 content",
                                List.of(
                                        minioService.getUrlForDownload(MinioBucketEnum.HOME_BANNER.getCode(), "head.png"),
                                        minioService.getUrlForDownload(MinioBucketEnum.HOME_BANNER.getCode(), "head.png")
                                ),
                                "comment 1 reply"
                        ),
                        new CommentDetailVO(
                                new UserInfoVO(
                                        minioService.getUrlForDownload(MinioBucketEnum.HOME_BANNER.getCode(), "head.png"),
                                        "comment nick name 2",
                                        2L,
                                        UserLevelEnum.LEVEL_1.getCode(),
                                        UserLevelEnum.LEVEL_1.getDesc(),
                                        "2024-06-28",
                                        "18357894352"
                                ),
                                "2024-06-28",
                                "comment 2 content",
                                List.of(
                                        minioService.getUrlForDownload(MinioBucketEnum.HOME_BANNER.getCode(), "head.png"),
                                        minioService.getUrlForDownload(MinioBucketEnum.HOME_BANNER.getCode(), "head.png")
                                ),
                                "comment 2 reply"
                        )
                )
        );
    }
}
