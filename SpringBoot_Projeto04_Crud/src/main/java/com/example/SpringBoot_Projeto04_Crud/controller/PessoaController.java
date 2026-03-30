package com.example.SpringBoot_Projeto04_Crud.controller;

import com.example.SpringBoot_Projeto04_Crud.model.Pessoa;
import com.example.SpringBoot_Projeto04_Crud.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pessoas")     // Define que todos os caminhos abaixo começam com /pessoas
public class PessoaController
{
    @Autowired
    private PessoaRepository repository;    // Acessa o banco de dados

    // --- MÉTODOS DO CRUD ---

    // 1. LISTAR: Abre a página principal com a lista e o formulário vazio
    @GetMapping
    public String listar(Model model)
    {
        // Todas as pessoas
        // Busca todos os registros do MySQL e guarda na lista "ListaDePessoas"
        model.addAttribute("ListaDePessoas", repository.findAll());

        // Pessoa específica
        // Cria um objeto "pessoa" para buscar pessoas específicas
        model.addAttribute("pessoa", new Pessoa());

        // Retorna o arquivo index.html que está na pasta templates
        return "index";
    }

    // 2. SALVAR: Recebe os dados do formulário e grava no banco
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Pessoa pessoa)
    {
        // O .save() é inteligente: Se a pessoa não tem ID, ele CRIA. Se tem ID, ele EDITA.
        repository.save(pessoa);

        // Após salvar, ele "manda" o navegador carregar a lista de novo
        return "redirect:/pessoas";
    }

    // 3. EDITAR: Busca os dados de uma pessoa específica e joga de volta no formulário
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model)
    {
        // Busca a pessoa no banco pelo ID que veio na URL
        model.addAttribute("pessoa", repository.findById(id).get());

        // Carrega a lista de novo para que a tabela não suma da tela enquanto editamos
        model.addAttribute("ListaDePessoas", repository.findAll());

        // Abre o index.html com o formulário agora preenchido com os dados da pessoa
        return "index";
    }

    // 4. DELETAR: Remove um registro do banco de dados
    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id)
    {
        // Comando que vai no MySQL e deleta a linha com esse ID
        repository.deleteById(id);

        // Recarrega a página para atualizar a lista sem a pessoa deletada
        return "redirect:/pessoas";
    }
}
