package com.bjpowernode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class MyController {

    /**
     * 处理器方法返回ModelAndView ，实现转发forward
     * 语法：setViewName("forward:视图文件的完整路径")
     * forward特点：不和视图解析器一起使用，就当项目中没有视图解析器
     *
     */
    @RequestMapping(value = "doForward.do") /*这个value值是数组，可以多个请求交给这一个doSome方法来处理*/
    public ModelAndView doSome(){ //doGet()--service请求处理
        ModelAndView mv=new ModelAndView();
        mv.addObject("msg","欢迎使用springmvc做web开发");
        mv.addObject("fun","执行的是doSome方法");
        //用了视图解析器，可以使用逻辑名称（文件的名字），指定视图

        //显示转发
        mv.setViewName("forward:/WEB-INF/view/show.jsp");

        //返会mv
        return  mv;
    }

    /**
     * 处理器方法返回ModelAndView，实现重定向redirect
     * 语法：setViewName（“redirect:视图完整路径”）
     * 特点：不和视图解析器一起使用，就当项目中没有视图解析器
     *
     * 1、框架会把/model中简单类型的数据转为字符串使用，作为hello.jsp的get请求参数使用
     * 目的是 在doRedirect.do和hello.jsp两次请求之间传递数据
     *
     * 2、在目标hello.jsp页面可以使用参数集合对象${param}
     *  ${param.myname}
     *
     * 3、重定向不能访问/WEB-INF资源
     *
     */
    @RequestMapping(value = "doRedirect.do",produces = "text/plain;charset=utf-8") /*这个value值是数组，可以多个请求交给这一个doSome方法来处理*/
    public ModelAndView doOther(String name,Integer age){ //doGet()--service请求处理
        ModelAndView mv=new ModelAndView();
        //数据放入到request作用域
        mv.addObject("myname",name);
        mv.addObject("myage",age);
        //用了视图解析器，可以使用逻辑名称（文件的名字），指定视图

        //重定向
        mv.setViewName("redirect:/hello.jsp");
        //http://localhost:8080/ch08_forward_redirect/hello.jsp?myname=%E6%9D%8E%E5%9B%9B&myage=22

        //返会mv
        return  mv;
    }


}
