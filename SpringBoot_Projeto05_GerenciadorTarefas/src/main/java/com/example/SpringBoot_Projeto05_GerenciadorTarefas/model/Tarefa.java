package com.example.SpringBoot_Projeto05_GerenciadorTarefas.model;

import jakarta.persistence.*;

@Entity
public class Tarefa
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descricao;

    // Este campo liga a tarefa ao usuário (Dono da tarefa)
    private Long usuarioId;

    public Tarefa() {}

    // Getter e Setter

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getDescricao()
    {
        return descricao;
    }

    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }

    public Long getUsuarioId()
    {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId)
    {
        this.usuarioId = usuarioId;
    }

}
