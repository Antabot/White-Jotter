package com.gm.wj.service;

import com.gm.wj.dao.AdminRoleDAO;
import com.gm.wj.pojo.AdminMenu;
import com.gm.wj.pojo.AdminPermission;
import com.gm.wj.pojo.AdminRole;
import com.gm.wj.pojo.AdminUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Evan
 * @date 2019/11
 */

@Service
public class AdminRoleService {
    @Autowired
    AdminRoleDAO adminRoleDAO;
    @Autowired
    UserService userService;
    @Autowired
    AdminUserRoleService adminUserRoleService;
    @Autowired
    AdminPermissionService adminPermissionService;
    @Autowired
    AdminMenuService adminMenuService;

    public List<AdminRole> list() {
        List<AdminRole> roles = adminRoleDAO.findAll();
        List<AdminPermission> perms;
        List<AdminMenu> menus;
        for (AdminRole role : roles) {
            perms = adminPermissionService.listPermsByRoleId(role.getId());
            menus = adminMenuService.getMenusByRoleId(role.getId());
            role.setPerms(perms);
            role.setMenus(menus);
        }
        return roles;
    }

    public AdminRole findById(int id) {
        return adminRoleDAO.findById(id);
    }

    public void addOrUpdate(AdminRole adminRole) {
        adminRoleDAO.save(adminRole);
    }

    public List<AdminRole> listRolesByUser(String username) {
        int uid =  userService.findByUserName(username).getId();
        List<AdminRole> roles = new ArrayList<>();
        List<AdminUserRole> urs = adminUserRoleService.listAllByUid(uid);
        for (AdminUserRole ur: urs) {
            roles.add(adminRoleDAO.findById(ur.getRid()));
        }
        return roles;
    }
}
