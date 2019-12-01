package com.gm.wj.service;

import com.gm.wj.dao.AdminRoleDAO;
import com.gm.wj.pojo.AdminRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminRoleService {
    @Autowired
    AdminRoleDAO adminRoleDAO;

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
}
