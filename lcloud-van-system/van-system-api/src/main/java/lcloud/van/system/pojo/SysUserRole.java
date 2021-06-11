package lcloud.van.system.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lcloud.van.core.base.BaseEntity;
import lombok.Data;

/**
 * 功能描述：
 *
 * @Author: XKK
 * @Date: 2021/6/1 15:25
 */
@Data
@TableName("sys_user_role")
public class SysUserRole{

    private Long userId;

    private Integer roleId;
}
