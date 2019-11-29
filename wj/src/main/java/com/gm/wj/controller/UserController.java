package com.gm.wj.controller;

import com.gm.wj.pojo.User;
import com.gm.wj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/api/admin/user")
    public List<User> list() throws Exception {
        return userService.list();
    }
}
