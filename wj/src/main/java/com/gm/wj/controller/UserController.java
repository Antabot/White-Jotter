package com.gm.wj.controller;

import com.gm.wj.entity.*;
import com.gm.wj.result.Result;
import com.gm.wj.result.ResultFactory;
import com.gm.wj.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * User controller.
 *
 * @author Evan
 * @date 2019/11
 */

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    AdminUserRoleService adminUserRoleService;

    @GetMapping("/api/admin/user")
    public Result listUsers() {
        return ResultFactory.buildSuccessResult(userService.list());
    }

    @PutMapping("/api/admin/user/status")
    public Result updateUserStatus(@RequestBody User requestUser) {
        if (userService.updateUserStatus(requestUser)) {
            return ResultFactory.buildSuccessResult("用户状态更新成功");
        } else {
            return ResultFactory.buildFailResult("参数错误，更新失败");
        }
    }

    @PutMapping("/api/admin/user/password")
    public Result resetPassword(@RequestBody User requestUser) {
        if (userService.resetPassword(requestUser)) {
            return ResultFactory.buildSuccessResult("重置密码成功");
        } else {
            return ResultFactory.buildFailResult("参数错误，重置失败");
        }
    }

    @PutMapping("/api/admin/user")
    public Result editUser(@RequestBody User requestUser) {
        if(userService.editUser(requestUser)) {
            return ResultFactory.buildSuccessResult("修改用户信息成功");
        } else {
            return ResultFactory.buildFailResult("参数错误，修改失败");
        }
    }
}
