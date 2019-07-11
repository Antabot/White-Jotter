package com.gm.wj.controller;

import javax.servlet.http.HttpSession;

import com.gm.wj.pojo.User;
import com.gm.wj.result.Result;
import com.gm.wj.result.ResultFactory;
import com.gm.wj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser, HttpSession session) {
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        User user = userService.get(username, requestUser.getPassword());
        if (null == user) {
            String message = "账号密码错误";
            return ResultFactory.buildFailResult(message);
        } else {
            session.setAttribute("user", user);
            return ResultFactory.buildSuccessResult(user);
        }
    }
}
