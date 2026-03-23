package com.example.SpringBoot_Projeto03_Forms.controller; // Verifique se o nome do seu projeto está certo aqui

import com.example.SpringBoot_Projeto03_Forms.model.Pessoa;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController
{

    // Lista do tipo Pessoa que simula um banco de dados em memória
    private List<Pessoa> listaPessoas = new ArrayList<>();

    // 1. Rota GET: Responsável por carregar/exibir a página no navegador
    @GetMapping("/usuarios")
    public String exibirPagina(Model model)
    {
        // Envia a lista de pessoas para o HTML (Thymeleaf)
        // "listaPessoasHTML" é o nome que será usado no arquivo HTML
        model.addAttribute("listaPessoasHTML", listaPessoas);

        // // Retorna o arquivo HTML: templates/user/index.html
        return "user/index";
    }

    // 2. Rota POST: Recebe os dados enviados pelo formulário
    @PostMapping("/cadastrar")
    public String cadastrarPessoa(Pessoa pessoa)        // É o Pessoa input do Java
    {
        // Adiciona a pessoa na lista (simulando salvar no banco)
        listaPessoas.add(pessoa);

        // Redireciona para a rota GET acima para atualizar a visualização da lista
        return "redirect:/usuarios";
    }
}

// Toda vez que tá chamando a rota "/usuarios" está chamando a função exibirPagina(Model model) no arquivo
// UserController, que é função que renderiza a página HTML