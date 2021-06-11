package lcloud.van.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import lcloud.van.system.pojo.SysResource;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 功能描述：
 *
 * @Author: XKK
 * @Date: 2021/6/2 10:27
 */
@Mapper
public interface SysResourceMapper extends BaseMapper<SysResource> {


    @Select(" select id,name,url from sys_resource ")
    @Results({
            @Result(id=true, column="id", property="id"),
            @Result(property = "roleIds",column="id",many = @Many(select="lcloud.van.system.dao.SysRoleResourceMapper.listByResourceId"))
    })
    List<SysResource> listForResourceRoles();
}
