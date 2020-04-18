package com.company.project.service.impl;

import com.company.project.dao.SysUserMapper;
import com.company.project.model.SysUser;
import com.company.project.service.SysUserService;
import com.company.project.common.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * @Author: YUEXIN
 * @Date: 2020-04-17 19:04:01
 */
@Service
@Transactional
public class SysUserServiceImpl extends AbstractService<SysUser> implements SysUserService {
    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser queryByName(String name) {
        return sysUserMapper.queryByName(name);
    }
}
