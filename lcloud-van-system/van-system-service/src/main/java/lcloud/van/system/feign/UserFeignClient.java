package lcloud.van.system.feign;

import cn.hutool.core.util.ObjectUtil;
import lcloud.van.core.result.Result;
import lcloud.van.core.result.ResultCodeEnum;
import lcloud.van.system.dto.UserDTO;
import lcloud.van.system.service.ISysUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述：
 *
 * @Author: XKK
 * @Date: 2021/5/28 10:58
 */
@RestController
@RequestMapping("/userFeign")
@AllArgsConstructor
public class UserFeignClient {

    private ISysUserService sysUserService;

    /**
     * 根据用户名获取用户详情
     */
    @GetMapping("/loadUserByName")
    public Result<UserDTO> loadUserByName(@RequestParam("username") String username) {
        UserDTO userDTO = sysUserService.loadUserByName(username);
        if(ObjectUtil.isNotEmpty(userDTO)) {
            return Result.success(userDTO);
        } else {
            return Result.failed(ResultCodeEnum.USER_NOT_EXIST);
        }
    }


}
