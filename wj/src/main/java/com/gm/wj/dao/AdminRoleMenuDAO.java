package com.gm.wj.dao;

import com.gm.wj.pojo.AdminRoleMenu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminRoleMenuDAO extends JpaRepository<AdminRoleMenu,Integer> {
    List<AdminRoleMenu> findAllByRid(int rid);
}
