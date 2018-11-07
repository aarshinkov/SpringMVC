package com.xcompany.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    
    private Logger log = LoggerFactory.getLogger(getClass());
    
    @GetMapping
    public String admin() {
        log.debug("Executing admin() begin --");
        
        log.debug("Redirecting to admin.html");
        return "admin/admin";
    }
    
}
