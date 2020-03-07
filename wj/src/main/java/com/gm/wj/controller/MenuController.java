package com.gm.wj.controller;

import com.gm.wj.entity.AdminMenu;
import com.gm.wj.service.AdminMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Menu controller.
 *
 * @author Evan
 * @date 2019/11
 */
@RestController
public class MenuController {
    @Autowired
    AdminMenuService adminMenuService;

    @GetMapping("/api/menu")
    public List<AdminMenu> menu() {
        return adminMenuService.getMenusByCurrentUser();
    }

    @GetMapping("/api/admin/role/menu")
    public List<AdminMenu> listAllMenus() {
        return adminMenuService.getMenusByRoleId(1);
    }
}
