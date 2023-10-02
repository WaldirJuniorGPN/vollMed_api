package com.vollmed.vollMed_api.dto.response;

import com.vollmed.vollMed_api.model.Endereco;
import com.vollmed.vollMed_api.model.Paciente;

public record DadosDetalhamentoPaciente(Long id, String nome, String email, String telefone, String cpf,
                                        Endereco endereco) {
    public DadosDetalhamentoPaciente(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getTelefone(), paciente.getCpf(), paciente.getEndereco());
    }
}
