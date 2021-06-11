package lcloud.van.system.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lcloud.van.core.base.BaseEntity;
import lombok.Data;

/**
 * 功能描述：
 *
 * @Author: XKK
 * @Date: 2021/6/2 10:23
 */
@Data
@TableName("sys_role_resource")
public class SysRoleResource extends BaseEntity<SysRoleResource> {

    private Integer roleId;
    private Integer resourceId;

}
