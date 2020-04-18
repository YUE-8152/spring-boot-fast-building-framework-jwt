package com.company.project.common.utils;

import com.company.project.model.SysUser;
import com.conpany.project.Tester;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import org.junit.Test;

public class JWTUtilsTest extends Tester {

    @Test
    public void testJWT() {
        SysUser user = new SysUser();
        user.setUserName("BB");
        user.setPassword("123456");
        String token = JWTUtils.createJWT(2 * 60 * 1000, user);

        try {
            System.out.println(JWTUtils.parseJWT(token, JWTUtils.JWTKEY));
        } catch (ExpiredJwtException e) {
            System.out.println("token已过期");
        } catch (SignatureException e) {
            System.out.println("签名校验失败");
        } catch (Exception e) {
            System.out.println("其它错误");
        }
    }
}