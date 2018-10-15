package top.yisen614.mybatisplusstart.dao.service.impl;

import top.yisen614.mybatisplusstart.dao.entity.User;
import top.yisen614.mybatisplusstart.dao.mapper.UserMapper;
import top.yisen614.mybatisplusstart.dao.service.IUserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
