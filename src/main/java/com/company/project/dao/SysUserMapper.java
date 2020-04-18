package com.company.project.dao;

import com.company.project.common.core.Mapper;
import com.company.project.model.SysUser;
import org.apache.ibatis.annotations.Param;

public interface SysUserMapper extends Mapper<SysUser> {
    SysUser queryByName(@Param(value = "userName") String name);
}