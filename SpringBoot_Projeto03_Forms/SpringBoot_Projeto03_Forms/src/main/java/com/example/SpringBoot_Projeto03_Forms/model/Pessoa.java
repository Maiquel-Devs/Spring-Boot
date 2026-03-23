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

    // Métodos Getter e Setter para usar nos Formularios
    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public int getIdade()
    {
        return idade;
    }

    public void setIdade(int idade)
    {
        this.idade = idade;
    }
}
