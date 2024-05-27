package com.hellChang.hellChangClub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bandMember")
public class BootBandController {
    @GetMapping("/save")

    public String saveForm(){
        return "bandMemberPages/saveForm";
    }
}
