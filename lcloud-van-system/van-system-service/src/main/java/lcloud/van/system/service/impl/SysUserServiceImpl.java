package lcloud.van.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lcloud.van.system.dao.SysUserMapper;
import lcloud.van.system.dto.UserDTO;
import lcloud.van.system.pojo.SysUser;
import lcloud.van.system.pojo.SysUserRole;
import lcloud.van.system.service.ISysUserRoleService;
import lcloud.van.system.service.ISysUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 功能描述：
 *
 * @Author: XKK
 * @Date: 2021/5/28 11:27
 */
@Service
@AllArgsConstructor
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    private ISysUserRoleService sysUserRoleService;

    /**
     * 根据用户名获取系统用户
     * @param username
     * @return
     */
    @Override
    public UserDTO loadUserByName(String username) {
        UserDTO userDTO = new UserDTO();
        SysUser sysUser = this.baseMapper.selectOne(new QueryWrapper<SysUser>().eq("username", username));
        if(ObjectUtil.isNotEmpty(sysUser)) {
            List<Integer> roleIds = sysUserRoleService.list(new LambdaQueryWrapper<SysUserRole>()
                    .eq(SysUserRole::getUserId,sysUser.getId()))
                    .stream().map(SysUserRole::getRoleId).collect(Collectors.toList());
            BeanUtil.copyProperties(sysUser,userDTO);
            userDTO.setRoles(roleIds);
        }
        return userDTO;
    }
}
