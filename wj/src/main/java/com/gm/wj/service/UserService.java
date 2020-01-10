package com.gm.wj.service;

import com.gm.wj.dao.UserDAO;
import com.gm.wj.pojo.AdminRole;
import com.gm.wj.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Evan
 * @date 2019/4
 */

@Service
public class UserService {
    @Autowired
    UserDAO userDAO;
    @Autowired
    AdminRoleService adminRoleService;

    public List<User> list() {
        List<User> users =  userDAO.list();
        List<AdminRole> roles;
        for (User user : users) {
            roles = adminRoleService.listRolesByUser(user.getUsername());
            user.setRoles(roles);
        }
        return users;
    }

    public boolean isExist(String username) {
        User user = findByUserName(username);
        return null!=user;
    }

    public User findByUserName(String username) {
        return userDAO.findByUsername(username);
    }

    public User get(String username, String password){
        return userDAO.getByUsernameAndPassword(username, password);
    }

    public void addOrUpdate(User user) {
        userDAO.save(user);
    }
}
