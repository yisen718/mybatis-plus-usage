package top.yisen614.mybatisplusstart.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.yisen614.mybatisplusstart.entity.User;
import top.yisen614.mybatisplusstart.enums.UserEnum;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
	@Autowired
	private UserMapper userMapper;

	@Test
	public void insert() {
		for (int i = 0; i < 100; i++) {
			User user = new User();
			user.setAccount("account" + i);
			user.setIsEnabled(1);
			user.setPassword("password");
			user.setDeleteFlag(1);
			user.setGender(UserEnum.MALE);
			user.setCreateTime(new Date());
			user.setUpdateTime(new Date());
			user.setSortTime(new Date());
			System.out.println(user);
			userMapper.insert(user);
		}
	}

	@Test
	public void deleteAll() {
		userMapper.deleteAll();
	}

	@Test
	public void deleteSample() {
		int n = userMapper.delete(new QueryWrapper<User>().eq(true, "pk_id", "06604d0187a7424988260101d3d9ffc9"));
		Assert.assertEquals(1, n);

		int n1 = userMapper.deleteById("0b1cc02b0411498787f6d4a7f75293e4");
		Assert.assertEquals(1, n1);

		int n2 = userMapper.deleteBatchIds(Arrays.asList("9b0ca9fba73c41c9bd5d195c5e3bb08d", "5bb7089244704a86aefa2192ff5be929", "20d35cfa268b4122946774be106fd956"));
		Assert.assertEquals(3, n2);
	}

	@Test
	public void select() {
		System.out.println("----- 普通查询 ------");
		List<User> users = userMapper.selectList(new QueryWrapper<User>().eq("account", "account5"));
		List<User> lambdaUsers = userMapper.selectList(new QueryWrapper<User>().lambda().eq(User::getAccount, "account5"));
		lambdaUsers.forEach(System.out::println);
		users.forEach(System.out::println);
		System.out.println("----- 带子查询(sql注入) ------");
		List<User> users1 = userMapper.selectList(new QueryWrapper<User>()
				.inSql("account", "select account from t_user where pk_id = '06299f1069de4f98aa640f08ef598e35'"));
		List<User> lambdaUsers2 = userMapper.selectList(new QueryWrapper<User>().lambda()
				.inSql(User::getAccount, "select account from t_user where pk_id = '06299f1069de4f98aa640f08ef598e35'"));
		users1.forEach(System.out::println);
		lambdaUsers2.forEach(System.out::println);

		System.out.println("----- 带嵌套查询 ------");
		List<User> users2 = userMapper.selectList(new QueryWrapper<User>()
				.nested(i -> i.eq("account", "account5").or().eq("pk_id", "06299f1069de4f98aa640f08ef598e35"))
				.and(i -> i.ge("password", "password5")));
		List<User> lambdaUsers3 = userMapper.selectList(new QueryWrapper<User>().lambda()
				.nested(i -> i.eq(User::getAccount, 2L).or().eq(User::getAccount, "account5"))
				.and(i -> i.ge(User::getPassword, "password5")));

		users2.forEach(System.out::println);
		lambdaUsers3.forEach(System.out::println);

		System.out.println("----- 自定义(sql注入) ------");
		List<User> users3 = userMapper.selectList(new QueryWrapper<User>()
				.apply("account = 'account5'"));

		users3.forEach(System.out::println);
	}

	@Test
	public void selectPage() {
		IPage<User> users = userMapper.selectPage(new Page<User>(10, 10), new QueryWrapper<User>().eq("password", "password"));
		List<User> users1 = users.getRecords();
		System.out.println(users1.get(0).getGender());
	}

	@Test
	public void activeUpdate() {
		Assert.assertTrue(new User().setPkId("0dfead7bba394cdd99c0d38e0acb5f9d").deleteById());
	}

	@Test
	public void deleteTest() {
//		new User().delete(new QueryWrapper<User>().eq("password", "password"));
		new User().delete(new QueryWrapper<User>().lambda().eq(User::getPassword, "password"));
	}

	@Test
	public void updateTest() {
//		Assert.assertTrue(new User().setPkId("0398a0f6b2d7460f9c796ddcedc91795").setPassword("drowssap").updateById());
		List<User> users = userMapper.selectList(new QueryWrapper<User>().select("pk_id", "account", "password").eq("pk_id", "4bf709874be64897a85e886bda49cc0d"));
		users.forEach(System.out::println);
	}
}