package lcloud.van.system.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lcloud.van.core.base.BaseEntity;
import lombok.Data;

import java.util.List;

/**
 * 功能描述：
 *
 * @Author: XKK
 * @Date: 2021/6/2 10:23
 */
@Data
@TableName("sys_resource")
public class SysResource extends BaseEntity<SysResource> {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String url;

    // 拥有资源权限角色ID集合
    @TableField(exist = false)
    private List<Integer> roleIds;

}
