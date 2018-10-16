package top.yisen614.mybatisplusstart.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.yisen614.mybatisplusstart.entity.User;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author 16539
 * @since 2018-10-15
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    void deleteAll();
}
