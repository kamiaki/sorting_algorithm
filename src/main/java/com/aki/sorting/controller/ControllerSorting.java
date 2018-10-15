package com.aki.sorting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 170725e on 2018/10/15.
 */
@Controller
public class ControllerSorting {

    @RequestMapping(value = "index")
    public String index(Model model){
        model.addAttribute("value1","value123");
        return "index";
    }
}
