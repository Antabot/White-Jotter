package com.gm.wj.service;

import com.gm.wj.dao.AdminRoleDAO;
import com.gm.wj.pojo.AdminPermission;
import com.gm.wj.pojo.AdminRole;
import com.gm.wj.pojo.AdminUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AdminRoleService {
    @Autowired
    AdminRoleDAO adminRoleDAO;
    @Autowired
    UserService userService;
    @Autowired
    AdminUserRoleService adminUserRoleService;

    public List<AdminRole> list() {
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        return adminRoleDAO.findAll(sort);
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
