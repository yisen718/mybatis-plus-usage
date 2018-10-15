package top.yisen614.mybatisplusstart.dao.service.impl;

import top.yisen614.mybatisplusstart.dao.entity.Article;
import top.yisen614.mybatisplusstart.dao.mapper.ArticleMapper;
import top.yisen614.mybatisplusstart.dao.service.IArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 16539
 * @since 2018-10-15
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {

}
