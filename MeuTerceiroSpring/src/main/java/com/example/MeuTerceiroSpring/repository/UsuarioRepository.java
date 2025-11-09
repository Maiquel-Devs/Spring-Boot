package com.example.MeuTerceiroSpring.repository; // Define o pacote onde o repositório está localizado

import com.example.MeuTerceiroSpring.model.Usuario; // Importa a entidade (tabela) Usuario
import org.springframework.data.jpa.repository.JpaRepository; // Importa a interface base do Spring Data JPA

// Interface que faz a ponte entre a entidade Usuario e o banco de dados
// JpaRepository fornece métodos prontos como save(), findAll(), deleteById(), etc.
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Não é necessário escrever nada aqui por enquanto.
    // O Spring Data JPA já cria automaticamente os métodos básicos de CRUD.
}


// import org.springframework.data.jpa.repository.JpaRepository;

// - Ela já traz métodos prontos para trabalhar com o banco, como:

// save() → salva ou atualiza registros
// findAll() → lista todos
// findById() → busca por ID
// deleteById() → exclui por ID