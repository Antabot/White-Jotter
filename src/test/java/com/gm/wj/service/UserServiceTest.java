package com.gm.wj.service;

import com.gm.wj.entity.AdminRole;
import com.gm.wj.entity.User;
import lombok.extern.log4j.Log4j2;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolationException;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;

@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    List<AdminRole> roles = new ArrayList<>();

    @Before
    public void before() {
        userService.addOrUpdate(User.builder().username("utest").build());
    }

    @Test
    @Transactional
    public void testEdit_Normal() {
        User user = User.builder().username("utest").email("123@456.com").phone("12312312312").roles(roles).build();
        userService.editUser(user);
        Assert.assertThat(userService.findByUsername("utest").getEmail(), is("123@456.com"));
        Assert.assertThat(userService.findByUsername("utest").getPhone(), is("12312312312"));
    }

    @Test
    @Transactional
    public void testEdit_EmailIsNullOrEmpty() {
        User user = User.builder().username("utest").email(null).roles(roles).build();
        userService.editUser(user);
        Assert.assertThat(userService.findByUsername("utest").getEmail(), nullValue());
        user.setEmail("");
        userService.editUser(user);
        Assert.assertThat(userService.findByUsername("utest").getEmail(), is(""));
    }

    @Test(expected = TransactionSystemException.class)
    public void testEdit_InvalidEmail() {
        User user = User.builder().username("utest").email("123").roles(roles).build();
        userService.editUser(user);
    }

    @Test(expected = ConstraintViolationException.class)
    public void testEdit_InvalidUsernameCase1() {
        User user = User.builder().username(null).build();
        userService.addOrUpdate(user);
    }

    @Test(expected = ConstraintViolationException.class)
    public void testEdit_InvalidUsernameCase2() {
        User user = User.builder().username("").build();
        userService.addOrUpdate(user);
    }

    @After
    public void after() {
        User user = userService.findByUsername("utest");
        userService.deleteById(user.getId());
    }
}
