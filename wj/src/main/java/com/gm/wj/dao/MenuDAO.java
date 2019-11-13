package com.gm.wj.dao;

import com.gm.wj.pojo.AdminMenu;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MenuDAO extends JpaRepository<AdminMenu, Integer> {
     AdminMenu findById(int id);
}

