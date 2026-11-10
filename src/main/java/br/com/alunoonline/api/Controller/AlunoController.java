package br.com.alunoonline.api.Controller;


import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//Spring não sabe de nada! temos que dizer a ele que isso é um controller por meio da anotação


@RestController // porta de entrada do front (vai receber as request e entregar as responses).
@RequestMapping("/alunos") //quando acessar /alunos ele vai usar o AlunoController
public class AlunoController {

    @Autowired // serve para injetar as coisas
    AlunoService alunoService; // se eu injeto então eu tenho ela dentro da outra classe
    // ter é diferente de usar

    //anotação de request e response
    @PostMapping //Requisição de criação
    @ResponseStatus(HttpStatus.CREATED) // Resposta da requisição (toda requisição precisa de uma reposta)
    public void criarAluno(@RequestBody Aluno aluno) {  // converteu o aluno de JSON (vindo do front) para o java
        alunoService.criarAluno(aluno); // pelo requestbody ele chega como json e foi para o service em java
    }

    @GetMapping //Requisição de Gettar todos os alunos
    @ResponseStatus(HttpStatus.OK) //Resposta desse get (200 ok)
    public List<Aluno> listarTodosAlunos() {
        return alunoService.listarTodosAlunos();
    }

    @GetMapping("/{id}") // precisa botar o id
    @ResponseStatus(HttpStatus.OK) //Resposta desse get (200 ok)
    public Optional<Aluno> buscarAlunoPorId(@PathVariable Long id) { // o caminho é a url / aluno / id do aluno
        return alunoService.buscarAlunoPorId(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarAlunoPorId(@PathVariable Long id) {
        alunoService.deletarAlunoPorId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // preciso do path pq é uma variavel que tá no caminho
    public void atualizarAlunoPorId(@PathVariable Long id, @RequestBody Aluno alunoEditado) { // esse fi da mae precisa do @requestbody pq vamos escrever e json e jay é no corpo
        alunoService.atualizarAlunoPorId(id, alunoEditado);
    }
}
