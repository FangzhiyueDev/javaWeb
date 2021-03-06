package com.fang.demo.model;


import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;

public class User implements Serializable {

    private String name;
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }


    public User() {

    }


//    @Override
//    public String toString() {
//        return "User{" +
//                "name='" + name + '\'' +
//                ", password='" + password + '\'' +
//                '}';
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
