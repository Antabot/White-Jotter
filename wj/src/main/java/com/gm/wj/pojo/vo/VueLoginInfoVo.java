package com.gm.wj.pojo.vo;
import javax.validation.constraints.NotNull;

public class VueLoginInfoVo {

    @NotNull(message = "用户名不允许为空")
    private String username;

    @NotNull(message = "密码不允许为空")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
