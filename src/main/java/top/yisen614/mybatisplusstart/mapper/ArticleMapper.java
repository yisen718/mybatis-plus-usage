package top.yisen614.mybatisplusstart.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;
import top.yisen614.mybatisplusstart.entity.Article;

import java.util.Date;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author 16539
 * @since 2018-10-15
 */
@Repository
public interface ArticleMapper extends BaseMapper<Article> {
	int insertArticle(Date date);
}
