package com.gm.wj.service;

import com.gm.wj.dao.AdminPermissionDAO;
import com.gm.wj.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AdminPermissionService {
    @Autowired
    AdminPermissionDAO adminPermissionDAO;
    @Autowired
    AdminUserRoleService adminUserRoleService;
    @Autowired
    AdminRoleService adminRoleService;
    @Autowired
    AdminRolePermissionService adminRolePermissionService;
    @Autowired
    UserService userService;

    public AdminPermission findById(int id) {
        return adminPermissionDAO.findById(id);
    }

    public boolean needFilter(String requestAPI) {
        List<AdminPermission> ps = adminPermissionDAO.findAll();
        for (AdminPermission p: ps) {
            if (p.getUrl().equals(requestAPI)) {
                return true;
            }
        }
        return false;
    }

    public Set<String> listPermissionURLsByUser(String username) {
        int uid =  userService.findByUserName(username).getId();
        List<AdminRole> roles = new ArrayList<>();
        List<AdminPermission> permissions = new ArrayList<>();
        Set<String> URLs = new HashSet<>();

        List<AdminUserRole> urs = adminUserRoleService.listAllByUid(uid);
        for (AdminUserRole ur: urs) {
            roles.add(adminRoleService.findById(ur.getRid()));
        }

        for (AdminRole role : roles) {
            List<AdminRolePermission> rps = adminRolePermissionService.findAllByRid(role.getId());
            for (AdminRolePermission rp : rps) {
                URLs.add(adminPermissionDAO.findById(rp.getPid()).getUrl());
            }
        }
        return URLs;
    }
}
