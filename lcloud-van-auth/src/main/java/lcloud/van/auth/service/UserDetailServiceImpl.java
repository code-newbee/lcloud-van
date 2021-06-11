package lcloud.van.auth.service;

import lcloud.van.auth.domain.User;
import lcloud.van.core.result.Result;
import lcloud.van.core.result.ResultCodeEnum;
import lcloud.van.system.api.UserFeignService;
import lcloud.van.system.dto.UserDTO;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * 功能描述：
 *
 * @Author: XKK
 * @Date: 2021/6/1 15:47
 */
@Service
@AllArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {
    private HttpServletRequest request;
    private UserFeignService userFeignService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String clientId = request.getParameter("client_id");

        Result<UserDTO> userRes = userFeignService.loadUserByName(username);
        if (ResultCodeEnum.USER_NOT_EXIST.getCode().equals(userRes.getCode())) {
            throw new UsernameNotFoundException(ResultCodeEnum.USER_NOT_EXIST.getMsg());
        }
        UserDTO userDTO = userRes.getData();
        userDTO.setClientId(clientId);
        User user = new User(userDTO);

        if (!user.isEnabled()) {
            throw new DisabledException("该账户已被禁用!");
        } else if (!user.isAccountNonLocked()) {
            throw new LockedException("该账号已被锁定!");
        } else if (!user.isAccountNonExpired()) {
            throw new AccountExpiredException("该账号已过期!");
        }
        return user;

    }
}
