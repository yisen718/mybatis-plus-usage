package top.yisen614.mybatisplusstart.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author 16539
 * @since 2018-10-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_user")
public class User extends Model<User> implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId("pk_id")
	private String pkId;

	private String account;

	private String password;

	private Integer isEnabled;

	private Enum gender;

	@TableLogic
	private Integer deleteFlag;

	private Date createTime;

	private Date updateTime;

	private Date sortTime;


	@Override
	protected Serializable pkVal() {
		return pkId;
	}
}
