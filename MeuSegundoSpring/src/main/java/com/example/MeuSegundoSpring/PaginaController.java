package com.example.MeuSegundoSpring;   // Define o pacote onde esta classe está localizada

import org.springframework.stereotype.Controller;    // Importa a anotação para marcar a classe como Controller
import org.springframework.web.bind.annotation.GetMapping;  // Importa a anotação para mapear requisições GET


@Controller     // Indica que esta classe é um controlador que responde a requisições web
public class PaginaController {

    // Define Rota
    @GetMapping("/")
    public String home() {
        return "home";  // irá renderizar home.html em templates
    }

    // Define Rota
    @GetMapping("/sobre")
    public String sobre() {
        return "sobre"; // irá renderizar sobre.html em templates
    }
}