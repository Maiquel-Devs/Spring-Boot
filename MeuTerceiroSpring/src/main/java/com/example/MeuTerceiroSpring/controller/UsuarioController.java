package com.example.MeuTerceiroSpring.controller;

import com.example.MeuTerceiroSpring.model.Usuario;
import com.example.MeuTerceiroSpring.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // --- ROTAS ---

    // Transforma a rota raiz ("/") em "/usuario/cadastrar"
    @GetMapping("/")
    public String home() {
        return "redirect:/usuario/cadastrar"; // redireciona para a página de cadastro
    }

    // --- FORMULÁRIOS ---

    // Página que mostra o formulário de cadastro de usuário
    @GetMapping("/usuario/cadastrar")
    public String mostrarFormularioCadastro(Model model) {
        model.addAttribute("usuario", new Usuario()); // prepara objeto para o formulário
        return "cadastrar"; // nome da view (template HTML) com o formulário
    }

    // Ação do formulário: salvar novo usuário via POST
    @PostMapping("/usuario/salvar")
    public String salvarUsuario(@ModelAttribute Usuario usuario) {
        usuarioRepository.save(usuario); // salva no banco o usuário recebido do formulário
        return "redirect:/usuario/listar"; // redireciona para lista após salvar
    }

    // --- ROTAS ---

    // Página para listar todos os usuários (mostra lista, não formulário)
    @GetMapping("/usuario/listar")
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioRepository.findAll());
        // Cria um objeto vazio do tipo Usuario e adiciona ao modelo com o nome "usuario"
        // para que o formulário no arquivo HTML possa acessar esse objeto e preencher seus campos

        return "listar"; // nome da view que mostra a lista de usuários
    }

    // Rota para remover usuário pelo ID
    @GetMapping("/usuario/remover/{id}")
    public String removerUsuario(@PathVariable Long id) {
        usuarioRepository.deleteById(id); // remove usuário do banco
        return "redirect:/usuario/listar"; // redireciona para a lista atualizada
    }
}


// Funções

// Mostram o formulário para o usuário inserir dados (mostrarFormularioCadastro)
// Recebem e salvam os dados enviados pelo formulário (salvarUsuario)
// Listam os dados cadastrados (listarUsuarios)
// Removem um registro específico (removerUsuario)