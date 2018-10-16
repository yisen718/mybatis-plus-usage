package top.yisen614.mybatisplusstart.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.yisen614.mybatisplusstart.entity.User;

import java.util.Arrays;
import java.util.List;

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
            user.setIsEnabled(1);
        }
    }


    @Test
    public void deleteSample() {
        int n = userMapper.delete(new QueryWrapper<User>().eq("pk_id", "06299f1069de4f98aa640f08ef598e35"));
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

}