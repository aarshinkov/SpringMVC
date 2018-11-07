package com.xcompany.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/contact")
public class ContactController {
    
    private Logger log = LoggerFactory.getLogger(getClass());
    
    @GetMapping
    public String contact() {
        log.debug("Executing contact() begin --");
        
        log.debug("Redirecting to contact.html");
        return "contact";
    }
    
}
