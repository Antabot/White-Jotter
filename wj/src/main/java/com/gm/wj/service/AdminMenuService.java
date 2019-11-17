package com.gm.wj.service;

import com.gm.wj.dao.AdminMenuDAO;
import com.gm.wj.pojo.AdminMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminMenuService {
    @Autowired
    AdminMenuDAO adminMenuDAO;

    public AdminMenu getOneById(int id) {
        return adminMenuDAO.findById(id);
    }
    public List<AdminMenu> getAllByParentId(int parentId) {return adminMenuDAO.findAllByParentId(parentId);}
}
