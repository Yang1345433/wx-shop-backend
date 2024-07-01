package yangcdtu.cn.wxshop.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import yangcdtu.cn.wxshop.vo.catalog.CategoryVO;

@TableName("category")
@Data
@AllArgsConstructor
public class Category {
    private Long id;
    private Long parentId;
    private String picUrl;
    private String frontName;
    private String name;

    public CategoryVO toVO() {
        return new CategoryVO(id, name);
    }
}
