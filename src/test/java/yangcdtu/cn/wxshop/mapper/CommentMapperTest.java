package yangcdtu.cn.wxshop.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import yangcdtu.cn.wxshop.bo.CommentPicsBO;
import yangcdtu.cn.wxshop.entity.Comment;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class CommentMapperTest {
    @Autowired
    private CommentMapper commentMapper;

    @Test
    public void saveComments() {
        List.of(
                new Comment(
                        null,
                        1L,
                        1L,
                        LocalDate.now().toString(),
                        "非常高级，很好用",
                        new CommentPicsBO(List.of("1head.jpeg", "1head.jpeg", "1head.jpeg"))
                ),
                new Comment(
                        null,
                        1L,
                        2L,
                        LocalDate.now().toString(),
                        "非常高级，很好用",
                        new CommentPicsBO(List.of("1head.jpeg", "1head.jpeg", "1head.jpeg"))
                )
        ).forEach(item -> commentMapper.insert(item));
    }

    @Test
    public void getComments() {
        System.out.println(commentMapper.selectList(new LambdaQueryWrapper<>()));
    }
}
