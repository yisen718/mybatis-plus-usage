package top.yisen614.mybatisplusstart.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.yisen614.mybatisplusstart.entity.Article;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleMapperTest {
	@Autowired
	private ArticleMapper articleMapper;

	@Test
	public void insert() {
		for (int i = 0; i < 10; i++) {
			Article article = new Article();
			article.setName("article:" + i);
			article.setPubDate(new Date());
			article.setPkId(UUID.randomUUID().toString());
			articleMapper.insert(article);
		}
	}

	@Test
	public void delete() {
		int n = articleMapper.delete(new QueryWrapper<Article>().eq("pk_id", "1b4fff9c-5909-4bc4-9ead-3f415145caf7"));
		Assert.assertEquals(1, n);
	}

	@Test
	public void deleteById() {
		int n = articleMapper.deleteById("25d37b23-5743-4019-b793-ad45323f7b0a");
	}

	@Test
	public void deleteMap() {
		Map<String, Object> map = new HashMap<>();
		map.put("pk_id", "5da834bc-f7a4-4a5a-9ec4-1e999f83a34e");
		map.put("name", "article:8");
		int n = articleMapper.deleteByMap(map);
		Assert.assertEquals(1, n);
	}

	@Test
	public void insertOne() {
		int n = articleMapper.insertArticle(new Date());
		Assert.assertEquals(1, n);
	}
}