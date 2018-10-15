package top.yisen614.mybatisplusstart.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.yisen614.mybatisplusstart.entity.Article;

import java.util.Date;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleMapperTest {
	@Autowired
	private ArticleMapper articleMapper;

	@Test
	public void name() {
		for (int i = 0; i < 10; i++) {
			Article article = new Article();
			article.setName("article:" + i);
			article.setPubDate(new Date());
			article.setPkId(UUID.randomUUID().toString());
			articleMapper.insert(article);
		}
	}
}