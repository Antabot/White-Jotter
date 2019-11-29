package com.gm.wj.controller;

import com.gm.wj.pojo.User;
import com.gm.wj.result.Result;
import com.gm.wj.result.ResultFactory;
import com.gm.wj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/api/admin/user")
    public List<User> list() throws Exception {
        return userService.list();
    }

    @PutMapping("/api/admin/user")
    public Result updateUserStatus(@RequestBody User requestUser) {
        User user = userService.getByUserName(requestUser.getUsername());
        user.setEnabled(requestUser.isEnabled());
        userService.addOrUpdate(user);
        String message = "用户"+ requestUser.getUsername() + "状态更新成功";
        return ResultFactory.buildSuccessResult(message);
    }
}
