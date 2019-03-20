package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 目标Handler类
 */
@Controller/*把该类交给Spring IOC管理*/
public class HelloController {


    /**
     * http://localhost:端口号/根路径/hello
     * 可以把你的url请求  映射到该方法进行处理
     * @return
     */
    @RequestMapping("/hello")
    public  String  hello(){
        System.out.println("hello-------------------------->");

        return "index";//转发到某个页面   加上前缀和后缀；===》/WEB-INf/jsp/index.jsp
    }
    /**
     * http://localhost:端口号/根路径/login
     * 可以把你的url请求  映射到该方法进行处理
     * @return
     */
    @RequestMapping("/login")
    public  String  login(){

        return "login";//转发到某个页面   加上前缀和后缀；===》/WEB-INf/jsp/login.jsp
    }
}
