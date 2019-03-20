package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 1.转发到jsp页面
 * 2.转发到其他控制器方法
 * 3.重定向到jsp[不能重定向到/WEB-INF/下的jsp文件]
 * 4.重定向到其他的控制器方法
 *
 *
 *
 * 	 * return  "index";转发  默认是转发到jsp页面  走视图解析器，需要加上前缀和后缀。
 * 	 * return "forward:/user/tologin"; 默认是转到其他的方法  不走走视图解析器
 * 	 * return "forward:/WEB-INF/jsp/index.jsp"; 不走视图解析器  要手动加前缀和后缀。
 * 	 *
 * 	 * return "redirect:/user/tologin";冲顶到到某个方法
 * 	 * return "redirect:/index.jsp"; 不走视图解析器  要手动前缀和后缀。
 *
 *
 *
 * 转发和重定向的区别：
 *  转发：副武器的行为  视为一次请求。在一次转发中 地址栏不会改变，转发可以通过request域对象来传递数据。只能在当前项目下进行转发。
 *
 *  重定向：浏览器的行为  地址栏会发生改变。不可以通过request域对象来传递数据。可以重定向到外网。重定向传递数据只能在地址栏里面传递数据。
 *
 */
@Controller
@RequestMapping("/f")
public class TestController2 {

    @RequestMapping("/a")
    public String test1(){
        System.out.println("a======================>");
        return "forward:/f/b";//不走视图解析器   不加前缀和后缀。
    }

    @RequestMapping("/b")
    public String test2(){
        System.out.println("b======================>");
        return "forward:/index.jsp";//往jsp页面进行转发   不走视图解析器   不加前缀和后缀。
    }


    @RequestMapping("/c")
    public String test3(){
        System.out.println("c======================>");
        return "redirect:/f/d";//重定向到d   不走视图解析器   不加前缀和后缀。
    }

    @RequestMapping("/d")
    public String test4(){
        System.out.println("d======================>");
        return "redirect:/index.jsp";//重定向到jsp   不走视图解析器   不加前缀和后缀。
    }


    @RequestMapping("/login")
    public String  login(String name,String pwd){
        System.out.println(name+"------------>"+pwd);
        return  "login";
    }
}
