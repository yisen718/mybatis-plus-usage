package top.yisen614.mybatisplusstart.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId("pk_id")
	private String pkId;

	private String account;

	private String password;

	@TableField("is_enabled")
	private Integer isEnabled;

	@TableField("delete_flag")
	private Integer deleteFlag;

	@TableField("create_time")
	private Date createTime;

	@TableField("update_time")
	private Date updateTime;

	@TableField("sort_time")
	private Date sortTime;
}
