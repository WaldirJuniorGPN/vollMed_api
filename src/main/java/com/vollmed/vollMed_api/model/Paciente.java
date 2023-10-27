package com.vollmed.vollMed_api.model;

import com.vollmed.vollMed_api.dto.request.DadosAtualizacaoPaciente;
import com.vollmed.vollMed_api.dto.request.DadosCadastroPaciente;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "Paciente")
@Table(name = "pacientes")
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;

    @Embedded
    private Endereco endereco;

    private boolean ativo;

    @OneToMany(mappedBy = "paciente")
    private List<Consulta> consultas;

    public Paciente(DadosCadastroPaciente dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.cpf = dados.cpf();
        this.endereco = new Endereco(dados.endereco());
        this.ativo = true;
    }

    public void atualizarPaciente(DadosAtualizacaoPaciente dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        this.endereco.atualizarEndereco(dados.endereco());
    }

    public void desativarPaciente() {
        this.ativo = false;
    }
}
