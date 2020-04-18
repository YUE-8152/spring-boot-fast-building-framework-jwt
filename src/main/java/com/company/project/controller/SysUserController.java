package com.company.project.controller;

import com.company.project.common.core.Result;
import com.company.project.common.core.ResultGenerator;
import com.company.project.common.core.ServiceException;
import com.company.project.common.utils.JWTUtils;
import com.company.project.model.SysUser;
import com.company.project.service.SysUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author: YUEXIN
 * @Date: 2020-04-17 19:04:01
 */
@RestController
@RequestMapping("/user")
public class SysUserController {
    @Resource
    private SysUserService sysUserService;

    @PostMapping("/add")
    public Result add(@RequestBody SysUser sysUser) {
        sysUserService.insert(sysUser);
        return ResultGenerator.suess();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        sysUserService.deleteById(id);
        return ResultGenerator.suess();
    }

    @PostMapping("/update")
    public Result update(@RequestBody SysUser sysUser) {
        sysUserService.update(sysUser);
        return ResultGenerator.suess();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        SysUser sysUser = sysUserService.findById(id);
        return ResultGenerator.suess(sysUser);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<SysUser> list = sysUserService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.suess(pageInfo);
    }

    @PostMapping("/login")
    public Result login(@RequestBody SysUser user, HttpServletResponse response) {
        SysUser sysUser = sysUserService.queryByName(user.getUserName());
        if (sysUser == null) {
            return ResultGenerator.fail("账号不存在.");
        }
        if (sysUser.getPassword().equals(user.getPassword())) {
            String token = JWTUtils.createJWT(2 * 60 * 1000, sysUser);
            response.setHeader("token", token);
            return ResultGenerator.suess(token);
        } else {
            return ResultGenerator.fail("账号密码不匹配.");
        }
    }
}
