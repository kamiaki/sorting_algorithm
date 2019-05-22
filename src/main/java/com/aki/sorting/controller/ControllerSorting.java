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
    public String index(){
        return "index";
    }

}
