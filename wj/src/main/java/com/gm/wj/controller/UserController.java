package com.gm.wj.controller;

import com.gm.wj.pojo.AdminRole;
import com.gm.wj.pojo.User;
import com.gm.wj.result.Result;
import com.gm.wj.result.ResultFactory;
import com.gm.wj.service.AdminRoleService;
import com.gm.wj.service.UserService;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    AdminRoleService adminRoleService;

    @GetMapping("/api/admin/user")
    public List<User> listUsers() throws Exception {
        return userService.list();
    }

    @PutMapping("/api/admin/user-status")
    public Result updateUserStatus(@RequestBody User requestUser) {
        User user = userService.findByUserName(requestUser.getUsername());
        user.setEnabled(requestUser.isEnabled());
        userService.addOrUpdate(user);
        String message = "用户" + requestUser.getUsername() + "状态更新成功";
        return ResultFactory.buildSuccessResult(message);
    }

    @PutMapping("api/password")
    public Result resetPassword(@RequestBody User requestUser) {
        User user = userService.findByUserName(requestUser.getUsername());
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        int times = 2;
        user.setSalt(salt);
        if (requestUser.getPassword() == null) {
            String encodedPassword = new SimpleHash("md5", "123", salt, times).toString();
            user.setPassword(encodedPassword);
        } else {
            String encodedPassword = new SimpleHash("md5", requestUser.getPassword(), salt, times).toString();
            user.setPassword(encodedPassword);
        }
        userService.addOrUpdate(user);
        String message = "修改密码成功";
        return ResultFactory.buildSuccessResult(message);
    }

    @PutMapping("api/admin/user")
    public Result editUser(@RequestBody User requestUser) {
        User user = userService.findByUserName(requestUser.getUsername());
        user.setName(requestUser.getName());
        user.setPhone(requestUser.getPhone());
        user.setEmail(requestUser.getEmail());
        userService.addOrUpdate(user);
        String message = "修改用户信息成功";
        return ResultFactory.buildSuccessResult(message);
    }

    @GetMapping("/api/admin/role")
    public List<AdminRole> listRoles() throws Exception {
        return adminRoleService.list();
    }

    @PutMapping("/api/admin/role")
    public Result updateRoleStatus(@RequestBody AdminRole requestRole) {
        AdminRole adminRole = adminRoleService.findById(requestRole.getId());
        adminRole.setEnabled(requestRole.isEnabled());
        adminRoleService.addOrUpdate(adminRole);
        String message = "用户" + adminRole.getNameZh() + "状态更新成功";
        return ResultFactory.buildSuccessResult(message);
    }
}
