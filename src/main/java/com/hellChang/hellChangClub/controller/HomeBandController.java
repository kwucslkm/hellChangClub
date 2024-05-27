package com.hellChang.hellChangClub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeBandController {
    @GetMapping("/")
    public String home(){
        return "home";
    }
}
