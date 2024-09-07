package br.edu.famper.funcionarios.api_funcionarios.resource;

import br.edu.famper.funcionarios.api_funcionarios.model.Funcionario;
import br.edu.famper.funcionarios.api_funcionarios.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funcionario")
public class FuncionarioResource {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public ResponseEntity<List<Funcionario>> findAll() {
        return funcionarioService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> findById(@PathVariable Long id) {
        return funcionarioService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Funcionario> save(@RequestBody Funcionario funcionario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioService.save(funcionario));
    }

    @PutMapping
    public ResponseEntity<Funcionario> update(@RequestBody Funcionario funcionario) {
        return ResponseEntity.status(HttpStatus.OK).body(funcionarioService.save(funcionario));
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody Funcionario funcionario) {
        funcionarioService.deleteById(funcionario.getId());
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
