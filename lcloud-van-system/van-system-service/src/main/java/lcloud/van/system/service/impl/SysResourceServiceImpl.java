package lcloud.van.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lcloud.van.system.dao.SysResourceMapper;
import lcloud.van.system.pojo.SysResource;
import lcloud.van.system.service.ISysResourceService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能描述：
 *
 * @Author: XKK
 * @Date: 2021/6/2 10:31
 */
@Service
public class SysResourceServiceImpl extends ServiceImpl<SysResourceMapper, SysResource> implements ISysResourceService {


    @Override
    public List<SysResource> listForResourceRoles() {
        return this.baseMapper.listForResourceRoles();
    }
}
