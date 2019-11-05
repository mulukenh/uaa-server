package com.wcs.legalization.uaaserver.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UaaController {


    @RequestMapping("/home")
    public String greetingForm(Model model) {
        return "<h1 style=\"color:green;text-align:center;\">Welcome to the HOME Page!<h1>";
    }

    @RequestMapping("/admin")
    public String getAdmin() {
        return "<h1 style=\"color:red;text-align:center;\">Welcome to the ADMIN Page!<h1>";
    }
}
