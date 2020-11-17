package com.gm.wj.controller;

import cn.hutool.json.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gm.wj.entity.User;
import com.gm.wj.result.Result;
import com.gm.wj.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.servlet.http.Cookie;

import static org.hamcrest.CoreMatchers.is;

/**
 * @author Evan
 * @date 2020/11/9 21:42
 *
 *  A failed attempt at unit testing of controllers.
 */
//@SpringBootTest
@RunWith(SpringRunner.class)
@WebMvcTest(value = LoginController.class)
public class LoginControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;


    @Test
    public void testLogin_Normal() throws Exception {
        User testUser = User.builder()
                .username("test").password("123").build();

        Mockito.when(userService.findByUsername("test")).thenReturn(testUser);

        String JSON = "{\"username\":\"test\",\"password\":\"123\"}";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/login")
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE).content(JSON)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        Assert.assertEquals(HttpStatus.OK.value(), response.getStatus());
        System.out.println(result.getResponse().getContentAsString() + "11111111111");
        String expected = "{\"code\":200,\"message\":\"成功\",\"result\":\"test\"}";
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }
}
