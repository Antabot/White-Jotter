package com.gm.wj.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.gm.wj.pojo.User;
import com.gm.wj.pojo.vo.VueLoginInfoVo;
import com.gm.wj.result.Result;
import com.gm.wj.result.ResultFactory;
import com.gm.wj.service.UserService;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import java.util.Objects;


@Controller
public class LoginController {

    /**
     * 登录控制器，前后端分离用的不同协议和端口，所以需要加入@CrossOrigin支持跨域。
     * 给VueLoginInfoVo对象加入@Valid注解，并在参数中加入BindingResult来获取错误信息。
     * 在逻辑处理中我们判断BindingResult知否含有错误信息，如果有错误信息，则直接返回错误信息。
     */

    @Autowired
    UserService userService;

    @CrossOrigin
    @RequestMapping(value = "/api/login", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Result login(@Valid @RequestBody VueLoginInfoVo loginInfoVo, HttpSession session) {
//        if (bindingResult.hasErrors()) {
//            String message = String.format("登陆失败，详细信息[%s]。", bindingResult.getFieldError().getDefaultMessage());
//            return ResultFactory.buildFailResult(message);
//        }
//        if (!Objects.equals("admin", loginInfoVo.getUsername()) || !Objects.equals("123", loginInfoVo.getPassword())) {
//            String message = String.format("登陆失败，详细信息[用户名、密码信息不正确]。");
//            return ResultFactory.buildFailResult(message);
//        }
//        User user = new User();
//        user.setUsername(loginInfoVo.getUsername());
//        user.setPassword(loginInfoVo.getPassword());
//        session.setAttribute("user",user);
//        return ResultFactory.buildSuccessResult("登陆成功。");
//    }

        String username = loginInfoVo.getUsername();
        username = HtmlUtils.htmlEscape(username);

        User user = userService.get(username, loginInfoVo.getPassword());
        if (null == user) {
            String message = "账号密码错误";
            return ResultFactory.buildFailResult(message);
        } else {
            session.setAttribute("user", user);
            return ResultFactory.buildSuccessResult("登录成功");
        }
    }
}