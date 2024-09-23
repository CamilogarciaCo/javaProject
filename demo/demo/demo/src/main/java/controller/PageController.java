package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String home() {
        // Esto busca el archivo 'index.html' en la carpeta 'static'
        return "index.html";
    }
}
