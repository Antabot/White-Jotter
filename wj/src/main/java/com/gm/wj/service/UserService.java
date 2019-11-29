package com.gm.wj.service;

import com.gm.wj.dao.UserDAO;
import com.gm.wj.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDAO userDAO;

    public List<User> list() {
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        return userDAO.findAll(sort);
    }

    public boolean isExist(String username) {
        User user = getByUserName(username);
        return null!=user;
    }

    public User getByUserName(String username) {
        return userDAO.findByUsername(username);
    }

    public User get(String username, String password){
        return userDAO.getByUsernameAndPassword(username, password);
    }

    public void addOrUpdate(User user) {
        userDAO.save(user);
    }
}
