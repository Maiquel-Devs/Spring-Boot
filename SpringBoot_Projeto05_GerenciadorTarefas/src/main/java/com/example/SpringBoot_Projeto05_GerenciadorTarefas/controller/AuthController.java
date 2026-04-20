package com.example.SpringBoot_Projeto05_GerenciadorTarefas.controller;

import com.example.SpringBoot_Projeto05_GerenciadorTarefas.model.Tarefa;
import com.example.SpringBoot_Projeto05_GerenciadorTarefas.model.Usuario;
import com.example.SpringBoot_Projeto05_GerenciadorTarefas.repository.TarefaRepository;
import com.example.SpringBoot_Projeto05_GerenciadorTarefas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AuthController
{
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TarefaRepository tarefaRepository;

    // Exibe a tela de cadastro
    @GetMapping("/registrar")
    public String exibirCadastro(Model model)
    {
        model.addAttribute("usuario", new Usuario());
        return "registrar";
    }

    @PostMapping("/registrar")
    public String registrarUsuario(Usuario usuario)
    {
        usuarioRepository.save(usuario);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String exibirLogin()
    {
        return "login";
    }

    @PostMapping("/login")
    public String logarUsuario(Usuario usuario, Model model)
    {
        // 1. O Spring busca no banco se esse nome existe
        Usuario userBanco = usuarioRepository.findByNome(usuario.getNome());

        // 2. O Spring verifica se o usuário existe e se a senha está correta
        if(userBanco != null && userBanco.getSenha().equals(usuario.getSenha()))
        {
            return "redirect:/dashboard?id=" + userBanco.getId();   // Passa o ID do usuário logado na URL
        }

        // 3. Se errar, volta para o login com uma mensagem de erro
        model.addAttribute("erro", "Usuário ou senha inválidos!");
        return "login";
    }

    @GetMapping("/dashboard")
    public String exibirDashboard(@RequestParam Long id, Model model)
    {
        // O Spring busca o usuário e as tarefas dele
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        List<Tarefa> tarefas = tarefaRepository.findByUsuarioId(id);

        model.addAttribute("usuario", usuario);
        model.addAttribute("listaTarefas", tarefas);

        return "dashboard";
    }

}
