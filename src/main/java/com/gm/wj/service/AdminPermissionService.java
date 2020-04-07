package com.gm.wj.service;

import com.gm.wj.dao.AdminPermissionDAO;
import com.gm.wj.dao.AdminRolePermissionDAO;
import com.gm.wj.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Evan
 * @date 2019/11
 */
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
    AdminRolePermissionDAO adminRolePermissionDAO;
    @Autowired
    UserService userService;

    public List<AdminPermission> list() {return adminPermissionDAO.findAll();}

    /**
     * Determine whether client requires permission when requests
     * a certain API.
     * @param requestAPI API requested by client
     * @return true when requestAPI is found in the DB
     */
    public boolean needFilter(String requestAPI) {
        List<AdminPermission> ps = adminPermissionDAO.findAll();
        for (AdminPermission p: ps) {
            // match prefix
            if (requestAPI.startsWith(p.getUrl())) {
                return true;
            }
        }
        return false;
    }

    public List<AdminPermission> listPermsByRoleId(int rid) {
        List<Integer> pids = adminRolePermissionService.findAllByRid(rid)
                .stream().map(AdminRolePermission::getPid).collect(Collectors.toList());
        return adminPermissionDAO.findAllById(pids);
    }

    public Set<String> listPermissionURLsByUser(String username) {
        List<Integer> rids = adminRoleService.listRolesByUser(username)
                .stream().map(AdminRole::getId).collect(Collectors.toList());

        List<Integer> pids = adminRolePermissionDAO.findAllByRid(rids)
                .stream().map(AdminRolePermission::getPid).collect(Collectors.toList());

        List<AdminPermission> perms = adminPermissionDAO.findAllById(pids);

        Set<String> URLs = perms.stream().map(AdminPermission::getUrl).collect(Collectors.toSet());

        return URLs;
    }
}
