package com.gm.wj.service;

import com.gm.wj.dao.AdminRoleMenuDAO;
import com.gm.wj.entity.AdminRoleMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author Evan
 * @date 2019/11
 */
@Service
public class AdminRoleMenuService {
    @Autowired
    AdminRoleMenuDAO adminRoleMenuDAO;

    public List<AdminRoleMenu> findAllByRid(int rid) {
        return adminRoleMenuDAO.findAllByRid(rid);
    }

    @Modifying
    @Transactional
    public void deleteAllByRid(int rid) {
        adminRoleMenuDAO.deleteAllByRid(rid);
    }

    public void save(AdminRoleMenu rm) {
        adminRoleMenuDAO.save(rm);
    }

    @Modifying
    @Transactional
    public boolean updateRoleMenu(int rid, LinkedHashMap menusIds) {
        try {
            deleteAllByRid(rid);
            for (Object value : menusIds.values()) {
                for (int mid : (List<Integer>) value) {
                    AdminRoleMenu rm = new AdminRoleMenu();
                    rm.setRid(rid);
                    rm.setMid(mid);
                    adminRoleMenuDAO.save(rm);
                }
            }
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }
}
