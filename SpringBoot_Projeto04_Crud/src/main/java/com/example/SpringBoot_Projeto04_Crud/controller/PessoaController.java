package com.example.SpringBoot_Projeto04_Crud.controller;

import com.example.SpringBoot_Projeto04_Crud.model.Pessoa;
import com.example.SpringBoot_Projeto04_Crud.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pessoas")
public class PessoaController
{
    @Autowired
    private PessoaRepository repository;    // Acessa o banco de dados

    // Aqui ele Gera a Lista e Abre o arquivo HTML
    @GetMapping
    public String listar(Model model)
    {
        // 1. Busca os dados no MySQL
        model.addAttribute("pessoas", repository.findAll());

        // 2. Prepara um objeto vazio para o formulário de cadastro
        model.addAttribute("pessoa", new Pessoa());

        // 3. RETORNA O NOME DO ARQUIVO HTML (sem o .html)
        return "index";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Pessoa pessoa)
    {
        repository.save(pessoa);
        return "redirect:/pessoas";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model)
    {
        model.addAttribute("pessoa", repository.findById(id).get());
        model.addAttribute("pessoas", repository.findAll());
        return "index";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id)
    {
        repository.deleteById(id);
        return "redirect:/pessoas";
    }
}
