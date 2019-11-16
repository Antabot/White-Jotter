package com.gm.wj.service;

import com.gm.wj.dao.AdminMenuDAO;
import com.gm.wj.pojo.AdminMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminMenuService {
    @Autowired
    AdminMenuDAO adminMenuDAO;

    public AdminMenu getOneById(int id) {
        return adminMenuDAO.findById(id);
    }
}
