package com.pdfsummarizer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Mapping the root URL ("/") to return the "index" Thymeleaf template
    @GetMapping("/")
    public String index() {
        return "index";  // This should map to src/main/resources/templates/index.html
    }
}
