package com.jiochem.carsproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CarsController {

    @RequestMapping(value = "/cars",  method = RequestMethod.GET)
    public ModelAndView cars() {
        ModelAndView mv = new ModelAndView("cars");
        return mv;
    }
}
