package com.example.SpringBoot_Projeto01_HellowSpring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController
{
    @GetMapping("/")
    public String home()
    {
        return "<h1>Sucesso!</h1><p>Hellow World Spring Boot !</p>";
    }
}