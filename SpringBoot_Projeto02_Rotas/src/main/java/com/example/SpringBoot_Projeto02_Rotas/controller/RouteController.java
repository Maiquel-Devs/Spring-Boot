package com.example.SpringBoot_Projeto02_Rotas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller     // Habilita as configurações de rotas html
public class RouteController
{
    @GetMapping("/") // Cria a rota "/"
    public String abrirPrimeira()
    {
        return "PrimeiraPagina"; // Procura PrimeiraPagina.html em templates
    }

    @GetMapping("/segunda") // Cria a rota "/segunda"
    public String abrirSegunda()
    {
        return "SegundaPagina"; // Procura SegundaPagina.html em templates
    }

}
