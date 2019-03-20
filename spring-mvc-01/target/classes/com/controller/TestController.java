package com.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;

@Controller
@RequestMapping("/user")
public class TestController {


    /**
     * RequestMapping注解：
     *      1.用在类上  表示窄化请求   该类里面的所有方法的路径url前面魔人都会加上 /user
     *      2.用在方法上
     *
     *      属性：
     *          value:表示该方法映射的请求路径  要唯一。
     *          method:用来指定请求方式 指定之后 该方法指支持指定的请求方式。否则会报错：Request method 'GET' not supported:请求方式不支持.
     *
     * @return : http://localhost/mvc/user/test
     */
    @RequestMapping(value = "/test",method = {RequestMethod.POST})
    public  String   test1(){

        System.out.println("test-------------->");

        return "index";//转发 到jsp  走视图解析器  加上视图解析器里面配置  前缀后缀
    }

    /**
     * SpringMVC获取表单数据非常简单
     *      只需要把表单数据写在方法的形参里就行了，形参名字要和表单的name属性值一致， 会帮我们进行基本类型的转换。
     *      方法形参的数据类型推荐些包装类型。
     *
     *     如果不一致怎么办？？表单的name属性值与方法的形参明不一致怎么办，我们需要使用@RequestParam()注解。
     *
     *     在方法的形参前面加上一个@RequestParam(value="user-agent")  value的值和表单的name的属性值一致就ok了。
     *
     * @RequestParam
     *              在方法的形参上
     *              属性：
     *                  1.value属性  value的值和表单的name的属性值 【形参明就可以不和表单的name值一样了】
     *                  2.required属性：默认是true指该表单必须有 没有的话则报错：HTTP Status 400 - Required String parameter 'user-agent' is not present
     *                  3.defaultValue 该属性的默认值  字符串类型
     *
     *
     *
     *      注意：如果表单传输的name属性值有多个的时候，比如?str=jack&str=rose. 方法里面用String  str接受的时候，得到的str内容是：jack,rose用逗号隔开。
     *      如果表单传输的name属性值有多个的时候，比如?str=jack&str=rose,mvc的方法里面也可以用String[] str来接受。
     *      如果表单传输的name属性值有多个的时候，比如?str=jack&str=rose,mvc的方法里面也可以用集合来接受，注意不能使用接口（List Set）。
     *       但是需要在形参前面加 @RequestParam("str")
     *
     * @return
     * User-Agent
     *
     */
    @RequestMapping("/register")
    public   String  register(@RequestParam(value="user-agent",defaultValue = "ssssss") String name,
                              Character sex, String pwd,
                              @RequestParam(defaultValue = "10") Integer age,
                              Double money,
                              String str,
                              String[] a,
                             @RequestParam("b")  ArrayList<String> list){


        System.out.println("name:"+name);
        System.out.println("sex:"+sex);
        System.out.println("pwd:"+pwd);
        System.out.println("age:"+age);
        System.out.println("money:"+money);
        System.out.println("str:"+str);
        System.out.println("a:"+ Arrays.toString(a));
        System.out.println(list);
        return "success";
    }

    /**
     * 分页控制器方法
     * @param pageSize
     * @param currentPage
     * @return
     */
    public  String  showUsersPage(@RequestParam(defaultValue = "10") Integer pageSize,
                                  @RequestParam(defaultValue = "1") Integer currentPage){


        return "list";
    }

    /**
     * 获取路径里的参数。
     * 比如：http://localhost:8080/mvc/user/product/1/adsads
     *  @RequestMapping("/product/{uid}")//{id}表示占位符  固定写法：{变量名}
     *   public   String  run4(@PathVariable("uid")  String id){}
     *   如果{}里面的变量和方法里面的形参名不一致的时候，需要给@PathVariable注解加上value属性，属性值和{}里面的变量名一致。
     *
     * @return
     */
    @RequestMapping("/product/{uid}")//{id}表示占位符  固定写法：{变量名}

    public   String  run4(@PathVariable("uid")  String id){

        System.out.println("------------>"+id);
        return "path";
    }

    @RequestMapping("getCookie")
    public   String  getCookie(@CookieValue("JSESSIONID") String id){
        System.out.println("cookie:"+id);

        return  "cookie";

    }

    @RequestMapping("getHeader")
    public   String  getHeader(@RequestHeader("User-Agent") String agent ){//浏览器的信息
        System.out.println("cookie:"+agent);

        return  "header";

    }

    /**
     * 通过表达式精准映射请求
     *
     * - params和headers支持简单的表达式
     *   1. param:表示请求必须包含名为param的请求参数
     *   2. !param:表示请求中不能包含名为param的参数
     *   3. param != value:表示请求中包含param的请求参数,但是值不能为value
     *   4. param = value:表示请求中包含param的请求参数,但是值为value
     * @return
     */
    @RequestMapping(value = "/run5",params = {"uname","age!=20"})
    public  String  run5(){

        return "run5";
    }
    /**
     *  ant风格的路径
     *
     * ant风格资源地址支持3种匹配符:
     *
     * 1. ?:匹配文件名中的一个字符
     * 2. *:匹配文件名中的任意字符
     * 3. **:匹配多层路径
     */

    @RequestMapping(value = "/**")
    public  String  run6(){

        return "run6";
    }
}
