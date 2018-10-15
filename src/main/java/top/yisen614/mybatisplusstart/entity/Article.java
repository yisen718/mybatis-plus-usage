package top.yisen614.mybatisplusstart.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
@TableName("t_article")
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    private String pkId;

    private String name;

    private Date pubDate;


}
