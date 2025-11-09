package com.example.MeuTerceiroSpring.model;   // Define o pacote onde esta classe está localizada (organização do projeto)

import jakarta.persistence.Entity;              // Indica que a classe representa uma tabela no banco de dados
import jakarta.persistence.GeneratedValue;      // Usado para gerar valores automáticos (como o ID)
import jakarta.persistence.GenerationType;      // Define o tipo de geração automática do ID
import jakarta.persistence.Id;                  // Marca o campo como chave primária (ID único)

@Entity                                         // Diz ao Spring que essa classe será uma entidade do banco de dados (tabela)
public class Usuario {                         // Declara a classe "Usuario", que representa a tabela "usuario"

    @Id                                         // Define que este campo é a chave primária da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Faz o banco gerar o ID automaticamente (auto incremento)
    private Long id;                            // Campo "id" do tipo Long — serve como identificador único

    private String nome;                        // Campo "nome" — representará uma coluna de texto no banco
    private Integer idade;                      // Campo "idade" — representará uma coluna numérica (inteiro)

    // Métodos Getters e Setters — usados para acessar e modificar os dados dos campos privados
    public Long getId() { return id; }          // Retorna o valor atual do ID
    public void setId(Long id) { this.id = id; } // Define um novo valor para o ID

    public String getNome() { return nome; }    // Retorna o valor do nome
    public void setNome(String nome) { this.nome = nome; } // Define um novo valor para o nome

    public Integer getIdade() { return idade; } // Retorna o valor da idade
    public void setIdade(Integer idade) { this.idade = idade; } // Define um novo valor para a idade
}



// Classe responsável por representar a tabela 'usuario' no banco de dados
// A anotação @Entity indica que esta classe é uma entidade JPA
// O campo 'id' é a chave primária (PRIMARY KEY) com incremento automático
// Os campos 'nome' e 'idade' são colunas comuns da tabela
// Os métodos Getter e Setter permitem acessar e modificar os valores desses campos
// Quando usamos o repository (ex: usuarioRepository.save()), o JPA usa os Getters/Setters
// para ler e gravar os dados na tabela 'usuario'