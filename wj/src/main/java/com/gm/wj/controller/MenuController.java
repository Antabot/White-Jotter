package com.gm.wj.controller;

import com.gm.wj.pojo.AdminMenu;
import com.gm.wj.pojo.AdminRoleMenu;
import com.gm.wj.pojo.AdminUserRole;
import com.gm.wj.pojo.User;
import com.gm.wj.service.AdminMenuService;
import com.gm.wj.service.AdminRoleMenuService;
import com.gm.wj.service.AdminUserRoleService;
import com.gm.wj.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class MenuController {
    @Autowired
    UserService userService;
    @Autowired
    AdminUserRoleService adminUserRoleService;
    @Autowired
    AdminRoleMenuService adminRoleMenuService;
    @Autowired
    AdminMenuService adminMenuService;

    @GetMapping("/api/menu")
    public List<AdminMenu> menu() {
        return respMenu(getMenuByRole());
    }

    public List<AdminMenu> getMenuByRole() {
        String username = SecurityUtils.getSubject().getPrincipal().toString();
        User user = userService.getByUserName(username);
        List<AdminUserRole> userRoleList = adminUserRoleService.listAllByUid(user.getId());
        List<AdminMenu> menus = new ArrayList<>();
        for (AdminUserRole userRole : userRoleList) {
            List<AdminRoleMenu> roleMenuList = adminRoleMenuService.listAllByRid(userRole.getRid());
            for (AdminRoleMenu roleMenu : roleMenuList) {
                menus.add(adminMenuService.getOneById(roleMenu.getMid()));
            }
        }
        return menus;
    }

    public List<AdminMenu> respMenu(List<AdminMenu> menus) {
        for (AdminMenu menu : menus) {
            menu.setChildren(adminMenuService.getAllByParentId(menu.getId()));
        }

        Iterator<AdminMenu> iterator = menus.iterator();
        while (iterator.hasNext()) {
            AdminMenu menu = iterator.next();
            if (menu.getParentId() != 0) {
                iterator.remove();
            }
        }
        return menus;
    }
}
