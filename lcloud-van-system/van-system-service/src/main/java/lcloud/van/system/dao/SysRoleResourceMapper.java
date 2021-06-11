package lcloud.van.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import lcloud.van.system.pojo.SysRoleResource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 功能描述：
 *
 * @Author: XKK
 * @Date: 2021/6/2 10:27
 */
@Mapper
public interface SysRoleResourceMapper extends BaseMapper<SysRoleResource> {

    @Select("<script>" +
            "   select role_id from sys_role_resource where resource_id=#{resourceId} " +
            "</script>")
    List<Integer> listByResourceId(Integer resourceId);
}
