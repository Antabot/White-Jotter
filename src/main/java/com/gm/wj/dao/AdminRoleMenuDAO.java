package com.gm.wj.dao;

import com.gm.wj.entity.AdminRoleMenu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Evan
 * @date 2019/11
 */
public interface AdminRoleMenuDAO extends JpaRepository<AdminRoleMenu,Integer> {
    List<AdminRoleMenu> findAllByRid(int rid);
    List<AdminRoleMenu> findAllByRid(List<Integer> rids);
    void deleteAllByRid(int rid);
}
