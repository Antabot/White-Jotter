package com.gm.wj.service;

import com.gm.wj.dao.AdminRoleMenuDAO;
import com.gm.wj.entity.AdminRole;
import com.gm.wj.entity.AdminRoleMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

    public List<AdminRoleMenu> findAllByRid(List<Integer> rids) {
        return adminRoleMenuDAO.findAllByRid(rids);
    }

    public void save(AdminRoleMenu rm) {
        adminRoleMenuDAO.save(rm);
    }

    @Modifying
    @Transactional
    public void updateRoleMenu(int rid, Map<String, List<Integer>> menusIds) {
        adminRoleMenuDAO.deleteAllByRid(rid);
        List<AdminRoleMenu> rms = new ArrayList<>();
        for (Integer mid : menusIds.get("menusIds")) {
            AdminRoleMenu rm = new AdminRoleMenu();
            rm.setMid(mid);
            rm.setRid(rid);
            rms.add(rm);
        }

        adminRoleMenuDAO.saveAll(rms);
    }
}
