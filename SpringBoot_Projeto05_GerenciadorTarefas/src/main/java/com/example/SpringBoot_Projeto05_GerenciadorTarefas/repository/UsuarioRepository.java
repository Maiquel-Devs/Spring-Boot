package com.example.SpringBoot_Projeto05_GerenciadorTarefas.repository;

import com.example.SpringBoot_Projeto05_GerenciadorTarefas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>
{
    // Método para buscar usuário pelo nome durante o login
    Usuario findByNome(String nome);
}
