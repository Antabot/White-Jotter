package com.gm.wj.controller;

import com.gm.wj.pojo.AdminMenu;
import com.gm.wj.service.AdminMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Evan
 * @date 2019/11
 */

@RestController
public class MenuController {
    @Autowired
    AdminMenuService adminMenuService;

    @GetMapping("/api/menu")
    public List<AdminMenu> menu() {
        List<AdminMenu> menus = adminMenuService.getMenusByCurrentUser();
        return menus;
    }

    @GetMapping("/api/admin/role/menu")
    public List<AdminMenu> listAllMenus() {
        List<AdminMenu> menus = adminMenuService.getMenusByRoleId(1);
        return menus;
    }
}
