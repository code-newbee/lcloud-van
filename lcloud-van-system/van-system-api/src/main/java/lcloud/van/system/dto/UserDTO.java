package lcloud.van.system.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 功能描述：
 *
 * @Author: XKK
 * @Date: 2021/6/1 14:51
 */
@Data
@NoArgsConstructor
public class UserDTO {

    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 客户端id
     */
    private String clientId;
    /**
     * 角色id集合
     */
    private List<Integer> roles;
}
