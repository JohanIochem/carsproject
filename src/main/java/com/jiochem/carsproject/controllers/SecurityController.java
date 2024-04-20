package com.jiochem.carsproject.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller()
public class SecurityController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView mv = new ModelAndView("login");
        return  mv;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    ModelAndView logout(){
        ModelAndView mv = new ModelAndView("logout");
        return mv;
    }
}
