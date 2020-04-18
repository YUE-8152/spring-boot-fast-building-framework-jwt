package com.company.project.service;

import com.company.project.model.SysUser;
import com.company.project.common.core.Service;


/**
 * @Author: YUEXIN
 * @Date: 2020-04-17 19:04:01
 */
public interface SysUserService extends Service<SysUser> {
    SysUser queryByName(String name);
}
