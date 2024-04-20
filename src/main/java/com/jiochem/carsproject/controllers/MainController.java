package com.jiochem.carsproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

        @RequestMapping("")
                public ModelAndView main(){
            ModelAndView mv = new ModelAndView("main");
            return mv;
        }

    }

