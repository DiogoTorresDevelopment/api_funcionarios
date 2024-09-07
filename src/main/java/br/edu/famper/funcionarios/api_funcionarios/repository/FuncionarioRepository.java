package br.edu.famper.funcionarios.api_funcionarios.repository;

import br.edu.famper.funcionarios.api_funcionarios.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
