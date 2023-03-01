package org.perscholas.onlineshoppingapp.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Controller
public class HomeController {
    public String homePage(){
        return  "index";
    }
}
