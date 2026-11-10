package br.com.alunoonline.api.model;

// importações

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// fim das importações


// O model é a tabela no banco de dados (Nesse caso é a tabela aluno)
//Os atributos são as colunas ( id, nome, matricula, cpf e email)



// Anotação sempre acima da linha do que vai anotar como o Entity e o ID.
@AllArgsConstructor // Gera construtores vazios
@NoArgsConstructor // gera construtores com campos
@Data  //gera os gets e sets. Loombok tira excesso de codigo
@Table (name = "aluno") // cria tabela aluno no banco de dados... além de ser uma entidade no back ele vai ser uma tabela no banco
@Entity // aluno é uma entidade
// estrutura jayzinho é chave x valor no caso "nome": "jao"
public class Aluno {

    @Id // chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeCompleto;

    private String matricula;

    private String cpf;

    private String email;

}