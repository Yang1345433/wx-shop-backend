package yangcdtu.cn.wxshop.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import yangcdtu.cn.wxshop.entity.Article;
import yangcdtu.cn.wxshop.mapper.ArticleMapper;
import yangcdtu.cn.wxshop.service.ArticleService;

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {
}
