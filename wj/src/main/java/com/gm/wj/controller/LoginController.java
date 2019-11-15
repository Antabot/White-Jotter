package com.gm.wj.controller;

import com.gm.wj.pojo.User;
import com.gm.wj.result.Result;
import com.gm.wj.result.ResultFactory;
import com.gm.wj.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

@RestController
public class LoginController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/api/login")
    public Result login(@RequestBody User requestUser) {
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        Subject subject = SecurityUtils.getSubject();
//        subject.getSession().setTimeout(10000);
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, requestUser.getPassword());
        usernamePasswordToken.setRememberMe(true);
        try {
            subject.login(usernamePasswordToken);
            // 生成随机 token 并存储在 session 中
            User user = userService.getByUserName(username);
            return ResultFactory.buildSuccessResult(usernamePasswordToken);
        } catch (AuthenticationException e) {
            String message = "账号密码错误";
            return ResultFactory.buildFailResult(message);
        }
    }

    @PostMapping("api/register")
    public Result register(@RequestBody User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        username = HtmlUtils.htmlEscape(username);
        user.setUsername(username);

        boolean exist = userService.isExist(username);

        if (exist) {
            String message = "用户名已被使用";
            return ResultFactory.buildFailResult(message);
        }

        // 默认生成 16 位盐
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        int times = 2;
        String encodedPassword = new SimpleHash("md5", password, salt, times).toString();

        user.setSalt(salt);
        user.setPassword(encodedPassword);
        userService.add(user);

        return ResultFactory.buildSuccessResult(user);
    }

    @GetMapping("api/logout")
    public Result logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        String message = "成功登出";
        return ResultFactory.buildSuccessResult(message);
    }

    @GetMapping(value = "api/authentication")
    public String authentication(){
        return "身份认证成功";
    }
}
