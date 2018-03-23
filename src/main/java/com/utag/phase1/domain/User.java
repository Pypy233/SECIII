package com.utag.phase1.domain;

/**
 * 用户信息的持久类
 */
import java.io.Serializable;

public class User implements Serializable {
    /**
     *用户名
     */
    public String username;


    /**
     *密码
     */
    public String password;


    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }


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
