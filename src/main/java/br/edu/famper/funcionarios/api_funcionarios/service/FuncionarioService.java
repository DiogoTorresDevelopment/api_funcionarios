package br.edu.famper.funcionarios.api_funcionarios.service;

import br.edu.famper.funcionarios.api_funcionarios.model.Funcionario;
import br.edu.famper.funcionarios.api_funcionarios.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;


    public ResponseEntity<List<Funcionario>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(funcionarioRepository.findAll());
    }

    public ResponseEntity<Funcionario> findById(Long id) {
        return funcionarioRepository.findById(id)
        .map(funcionario -> ResponseEntity.status(HttpStatus.OK).body(funcionario)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public Funcionario save(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario update(Funcionario funcionario) {
        Funcionario funcionarioSalvo = funcionarioRepository.findById(funcionario.getId())
                .orElseThrow(() -> new RuntimeException("Funcionario não encontrado!"));

        funcionarioSalvo.setNome(funcionario.getNome());
        funcionarioSalvo.setCargo(funcionario.getCargo());
        funcionarioSalvo.setDepartamento(funcionario.getDepartamento());
        funcionarioSalvo.setDataAdmissao(funcionario.getDataAdmissao());
        funcionarioSalvo.setEmail(funcionario.getEmail());
        funcionarioSalvo.setTelefone(funcionario.getTelefone());

        return funcionarioRepository.save(funcionario);
    }

    public void deleteById(Long id) {
        funcionarioRepository.deleteById(id);
    }

}
