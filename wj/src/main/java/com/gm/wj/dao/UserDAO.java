package com.gm.wj.dao;

import com.gm.wj.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Evan
 * @date 2019/4
 */

public interface UserDAO extends JpaRepository<User,Integer> {
    User findByUsername(String username);

    User getByUsernameAndPassword(String username,String password);

    @Query(value = "select new User(u.id,u.username,u.name,u.phone,u.email,u.enabled) from User u")
    List<User> list();
}
