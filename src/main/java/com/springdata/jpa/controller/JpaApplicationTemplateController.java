package com.springdata.jpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * Template Controller, thymleaf is used
 * Need to use Controller
 */
@Controller
@RequestMapping("/")
public class JpaApplicationTemplateController {

    @GetMapping("login")
    public String getLogin(){
        return "login";
    }
}
