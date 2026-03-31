package com.example.SpringBoot_Projeto04_Crud.repository;

import com.example.SpringBoot_Projeto04_Crud.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>
{
    // Aqui já temos os métodos save(), findAll(), deleteById(), etc.
}

// Cria a tabela pessoa usando o Molde do Pessoa.Java "Arrumar esse texto"