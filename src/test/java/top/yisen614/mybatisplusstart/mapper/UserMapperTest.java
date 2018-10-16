package top.yisen614.mybatisplusstart.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.yisen614.mybatisplusstart.entity.User;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
	@Autowired
	private UserMapper userMapper;

	@Test
	public void name() {
		for (int i = 0; i < 10; i++) {
			User user = new User();
			user.setAccount("account" + i);
			user.setPassword("password" + i);
			user.setSortTime(new Date());
			user.setUpdateTime(new Date());
			user.setCreateTime(new Date());
			user.setDeleteFlag(1);
			user.setIsEnabled(1);
			userMapper.insert(user);
		}
	}
}