package com.vollmed.vollMed_api.dto.response;

import com.vollmed.vollMed_api.model.Endereco;
import com.vollmed.vollMed_api.model.Paciente;

public record DadosListagemPaciente(Long id, String nome, String email, String telefone, String cpf,
                                    Endereco endereco) {
    public DadosListagemPaciente(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getTelefone(), paciente.getCpf(), paciente.getEndereco());
    }
}
