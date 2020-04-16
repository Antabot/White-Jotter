package com.gm.wj.service;

import com.gm.wj.dao.UserDAO;
import com.gm.wj.dto.UserDTO;
import com.gm.wj.entity.AdminRole;
import com.gm.wj.entity.User;
import lombok.extern.log4j.Log4j2;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;

@Log4j2
@RunWith(MockitoJUnitRunner.class)
//@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Mock
    private UserDAO userDAO;
    @Mock
    private AdminRoleService adminRoleService;
    @InjectMocks
    private UserService userService;

    List<User> users = new ArrayList<>();
    List<AdminRole> roles = new ArrayList<>();

    @Before
    public void before() {

    }

    @Test
    public void testList() {
        User testUser = User.builder().username("utest").build();
        AdminRole testRole = AdminRole.builder().name("rtest").build();
        users.add(testUser);
        roles.add(testRole);

        when(userDAO.findAll()).thenReturn(users);
        when(adminRoleService.listRolesByUser(testUser.getUsername())).thenReturn(roles);

        List<UserDTO> userDTOS = userService.list();
        Assert.assertThat(userDTOS.get(0).getUsername(), is("utest"));
        Assert.assertThat(userDTOS.get(0).getRoles().get(0).getName(), is("rtest"));
    }

    @Test
    public void testRegister_Normal() {
        User testUser = User.builder()
                .username("utest").password("123").name("测试用户").email("123@456.com").phone("12312312312").build();

        when(userDAO.save(any(User.class))).thenAnswer(i ->  i.getArguments()[0]);

        Assert.assertThat(userService.register(testUser), is(1));
    }

    @Test
    public void testResetPassword_Normal() {
        User testUser = User.builder()
                .username("utest").password("123456").name("测试用户").email("123@456.com").phone("12312312312").build();

        when(userDAO.findByUsername("utest")).thenReturn(testUser);
        when(userDAO.save(any(User.class))).thenAnswer(i ->  i.getArguments()[0]);

        User resetUser = userService.resetPassword(testUser);
        Assert.assertThat(resetUser.getPassword(),is(new SimpleHash("md5", "123", resetUser.getSalt(), 2).toString()));
    }

    @After
    public void after() {

    }
}
