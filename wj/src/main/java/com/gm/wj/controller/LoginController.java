package com.gm.wj.controller;

import com.gm.wj.pojo.vo.VueLoginInfoVo;
import com.gm.wj.result.Result;
import com.gm.wj.result.ResultFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;

@Controller
public class LoginController {

    @CrossOrigin
    @RequestMapping(value = "/api/login", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Result login(@Valid @RequestBody VueLoginInfoVo loginInfoVo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String message = String.format("登录失败，详细信息[%s]。", bindingResult.getFieldError().getDefaultMessage());
            return ResultFactory.buildFailResult(message);
        }
        if (!Objects.equals("admin", loginInfoVo.getUsername()) || !Objects.equals("123", loginInfoVo.getPassword())) {
            String message = String.format("登陆失败，详细信息[用户名、密码信息不正确]。");
            return ResultFactory.buildFailResult(message);
        }
        return ResultFactory.buildSuccessResult("登录成功");
    }
}
