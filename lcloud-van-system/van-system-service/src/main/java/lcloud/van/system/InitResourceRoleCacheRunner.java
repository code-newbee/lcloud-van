package lcloud.van.system;

import cn.hutool.core.collection.CollectionUtil;
import lcloud.van.core.constants.AuthConstants;
import lcloud.van.system.pojo.SysResource;
import lcloud.van.system.service.ISysResourceService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * 功能描述：
 *
 * @Author: XKK
 * @Date: 2021/6/2 10:16
 */
@Component
@Slf4j
@AllArgsConstructor
public class InitResourceRoleCacheRunner implements CommandLineRunner {

    private RedisTemplate redisTemplate;

    private ISysResourceService sysResourceService;

    @Override
    public void run(String... args) throws Exception {
        log.info("InitResourceRoleCacheRunner run");
        //删除旧的权限缓存
        redisTemplate.delete(AuthConstants.RESOURCE_ROLES_KEY);

        List<SysResource> resources = sysResourceService.listForResourceRoles();
        Map<String, List<String>> resourceRolesMap = new TreeMap<>();
        Optional.ofNullable(resources).orElse(new ArrayList<>()).forEach(resource -> {

            // 转换 roleId -> ROLE_{roleId}
            List<String> roles = Optional.ofNullable(resource.getRoleIds()).orElse(new ArrayList<>())
                    .stream().map(roleId -> AuthConstants.AUTHORITY_PREFIX + roleId)
                    .collect(Collectors.toList());

            if (CollectionUtil.isNotEmpty(roles)) {
                resourceRolesMap.put(resource.getUrl(), roles);
            }

            redisTemplate.opsForHash().putAll(AuthConstants.RESOURCE_ROLES_KEY, resourceRolesMap);
        });




    }
}
