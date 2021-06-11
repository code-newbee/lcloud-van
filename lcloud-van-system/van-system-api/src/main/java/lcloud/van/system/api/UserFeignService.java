package lcloud.van.system.api;

import lcloud.van.core.result.Result;
import lcloud.van.system.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 功能描述：
 *
 * @Author: XKK
 * @Date: 2021/6/1 14:49
 */
@FeignClient("van-system")
public interface UserFeignService {

    @GetMapping("/userFeign/loadUserByName")
    Result<UserDTO> loadUserByName(@RequestParam("username") String username);
}
