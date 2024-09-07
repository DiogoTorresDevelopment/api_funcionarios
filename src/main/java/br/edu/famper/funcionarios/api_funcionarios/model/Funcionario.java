package br.edu.famper.funcionarios.api_funcionarios.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

@Entity
@Table(name = "funcionario")
@Data
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "nome", length = 150)
    private String nome;

    @NotNull
    @Column(name = "cargo", length = 150)
    private String cargo;

    @NotNull
    @Column(name = "departamento", length = 150)
    private String departamento;

    @NotNull
    @Column(name = "data_admissao")
    private Date dataAdmissao;


    @NotNull
    @Column(name = "email", length = 150)
    private String email;

    @NotNull
    @Column(name = "telefone", length = 20)
    private String telefone;

}
