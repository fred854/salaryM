package com.sal.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("salarym")
@Api(value = "HomeController|跳转控制")
public class HomeController {
    @RequestMapping(value = "/lo",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String home(HttpServletRequest request){
        boolean check=this.check(request);
        if(check){
            return "home2";
        }
        else
            return "login";
    }

    @RequestMapping(value = "/position",method = RequestMethod.GET)
    public String position(HttpServletRequest request){
        boolean check=this.check(request);
        if(check){
            return "position";
        }
        else
            return "login";
    }

    @RequestMapping(value = "/salaryKind",method = RequestMethod.GET)
    public String salaryKind(HttpServletRequest request){
       boolean check=this.check(request);
       if(check){
           return "salarykind";
       }
       else
           return "login";
    }

    @RequestMapping(value = "/person",method = RequestMethod.GET)
    public String person(HttpServletRequest request){
        boolean check=this.check(request);
        if(check){
            return "person";
        }
        else
            return "login";
    }

    @RequestMapping(value = "/salary",method = RequestMethod.GET)
    public String salary(HttpServletRequest request){
        boolean check=this.check(request);
        if(check){
            return "salary";
        }
        else
            return "login";
    }

    @RequestMapping(value = "/statistics",method = RequestMethod.GET)
    public String statistics(HttpServletRequest request){
        boolean check=this.check(request);
        if(check){
            return "statistics";
        }
        else
            return "login";
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest request){
        boolean check=this.check(request);
        if(check){
            HttpSession sessoin=request.getSession();
            sessoin.removeAttribute("username");
            return "login";
        }
        else
            return "login";
    }
    public Boolean check(HttpServletRequest request){
        HttpSession sessoin=request.getSession();
        String username=(String)sessoin.getAttribute("username");
        System.out.println(username);
        if (username==null||username.equals(""))
            return false;
        else
            return true;
    }


    @RequestMapping(value = "/home3",method = RequestMethod.GET)
    public String home3(){
        return "/page/home3.html";
    }
}
