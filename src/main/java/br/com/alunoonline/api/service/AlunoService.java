package br.com.alunoonline.api.service;


import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


//Service é onde se aplica as regras de negócio
// Primeira regra de negócio é o criar... mas o service não tem acesso ao banco de dados por isso tem que injetar o repository
//é aqui onde se faz o CRUD

@Service
public class AlunoService {

    @Autowired // injeta repository no service
    AlunoRepository alunoRepository;

    public void criarAluno(Aluno aluno) {
        alunoRepository.save(aluno);
    }


    public List<Aluno> listarTodosAlunos() {
        return alunoRepository.findAll();

    }


    public Optional<Aluno> buscarAlunoPorId(Long id) {
        return alunoRepository.findById(id);
    }

    public void deletarAlunoPorId(Long id) { // void pq essa porra de aluno vai ser deletado e se foi deletado n tem nda para retornar
        alunoRepository.deleteById(id);
    }

    // aluno editado vem do front.. chega no controller e o controller manda para ca
    public void atualizarAlunoPorId(Long id, Aluno alunoEditado) {
        alunoEditado.setId(id);
        alunoRepository.save(alunoEditado);
    }

}

