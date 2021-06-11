package lcloud.van.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import lcloud.van.system.pojo.SysResource;

import java.util.List;

/**
 * 功能描述：
 *
 * @Author: XKK
 * @Date: 2021/6/2 10:29
 */
public interface ISysResourceService extends IService<SysResource> {

    /**
     * 获取所有资源角色
     * @return
     */
    List<SysResource> listForResourceRoles();
}
