package com.example.SpringBoot_Projeto03_Forms.model;

public class Pessoa
{
    private String nome;
    private int idade;

    // Construtor (Para criar a pessoa com dados)
    public Pessoa(String nome, int idade)
    {
        this.nome = nome;
        this.idade = idade;
    }

    // Apenas os Métodos Getters (O Thymeleaf usa isso para ler o dado e mostrar na tela)
    public String getNome()
    {
        return nome;
    }

    public int getIdade()
    {
        return idade;
    }
}
