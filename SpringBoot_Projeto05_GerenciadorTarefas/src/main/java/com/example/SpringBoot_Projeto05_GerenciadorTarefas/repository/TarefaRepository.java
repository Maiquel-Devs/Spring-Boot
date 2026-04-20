package com.example.SpringBoot_Projeto05_GerenciadorTarefas.repository;

import com.example.SpringBoot_Projeto05_GerenciadorTarefas.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarefaRepository  extends JpaRepository<Tarefa, Long>
{
    // O Spring gera o SQL: SELECT * FROM tarefa WHERE usuario_id = ?
    List<Tarefa> findByUsuarioId(Long usuarioId);
}
