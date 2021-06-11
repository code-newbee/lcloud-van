package lcloud.van.system.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lcloud.van.core.base.BaseEntity;
import lombok.Data;

/**
 * 功能描述：
 *
 * @Author: XKK
 * @Date: 2021/6/1 14:50
 */
@Data
@TableName("sys_user")
public class SysUser extends BaseEntity<SysUser> {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String username;

    private String nickname;

    private String mobile;

    private Integer gender;

    private String avatar;

    private String password;

    private Integer status;

    private Integer deptId;

    private Integer deleted;

    @TableField(exist = false)
    private String deptName;
}
