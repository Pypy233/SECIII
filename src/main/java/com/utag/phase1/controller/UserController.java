package com.utag.phase1.controller;


import com.utag.phase1.service.Impl.UserServiceImpl;
import com.utag.phase1.service.UserService;
import com.utag.phase1.util.FileTool;
import com.utag.phase1.util.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.*;


@Controller
public class UserController {

    UserService userService = new UserServiceImpl();

    @RequestMapping("/")
    public String getIndex(){
        return "/index.html";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public Response<Boolean> canLogin(String user, String password) throws IOException{
        System.out.println("Get login...");
        System.out.println(user);
        System.out.println(password);
        return userService.canLogin(user, password);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Response<Boolean> register(String user, String password)throws IOException{
        System.out.println("Get Register...");
        return userService.saveUser(user, password);
    }


}
