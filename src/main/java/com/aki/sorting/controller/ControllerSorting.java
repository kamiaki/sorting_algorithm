package com.aki.sorting.controller;

import com.aki.sorting.service.ServiceSorting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Aki on 2018/10/15.
 */
@Controller
public class ControllerSorting {
    @Autowired
    @Qualifier(value = "sort")
    ServiceSorting serviceSorting;

    @RequestMapping(value = "index")
    public String index(Model model){
        model.addAttribute("value1","value123");
        return "index";
    }

    @ResponseBody
    @RequestMapping(value="bubblesort")
    public String bubblesort()throws Exception{
        int[] ints = {34,2,13,44,345};
        serviceSorting.bubblesort(ints);
        System.out.println(ints);
        return "pass";
    }
}
