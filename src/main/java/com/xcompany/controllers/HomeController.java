package com.xcompany.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class HomeController {
    
    private Logger log = LoggerFactory.getLogger(getClass());
    
    @GetMapping
    public String home() {
        log.debug("Executing home() begin --");
        
        log.debug("Redirecting to home.html");
        return "home";
    }
    
}
