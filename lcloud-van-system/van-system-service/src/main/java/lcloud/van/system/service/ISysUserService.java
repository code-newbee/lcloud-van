package lcloud.van.system.service;


import com.baomidou.mybatisplus.extension.service.IService;
import lcloud.van.system.dto.UserDTO;
import lcloud.van.system.pojo.SysUser;

/**
 * 功能描述：
 *
 * @Author: XKK
 * @Date: 2021/5/28 10:58
 */
public interface ISysUserService extends IService<SysUser> {

    /**
     * 根据用户名获取系统用户-feign
     * @param username
     * @return
     */
    UserDTO loadUserByName(String username);
}
