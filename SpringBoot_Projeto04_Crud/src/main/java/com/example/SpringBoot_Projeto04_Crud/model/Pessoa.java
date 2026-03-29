package com.example.SpringBoot_Projeto04_Crud.model;

import jakarta.persistence.*;

@Entity
public class Pessoa
{
    @Id     // Chave Primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // O MySQL gera o ID (1, 2, 3...)
    private Long id;

    private String nome;

    private int idade;

    // Construtor vazio (obrigatório para o JPA)
    public Pessoa(){}

    // Getters e Setters
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

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
