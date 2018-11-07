package com.xcompany.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/profile")
public class ProfileController {
    
    private Logger log = LoggerFactory.getLogger(getClass());
    
    @GetMapping
    public String profile() {
        log.debug("Executing profile() begin --");
        
        log.debug("Redirecting to profile.html");
        return "profile/profile";
    }
    
}
