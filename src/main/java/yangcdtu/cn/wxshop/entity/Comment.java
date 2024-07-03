package yangcdtu.cn.wxshop.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import yangcdtu.cn.wxshop.bo.CommentPicsBO;

@TableName("comment")
@Data
@AllArgsConstructor
public class Comment {
    private Long id;
    private Long goodsId;
    private Long userId;
    private String addTime;
    private String content;
    private CommentPicsBO picList;
}
