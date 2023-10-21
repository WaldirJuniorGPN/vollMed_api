package com.vollmed.vollMed_api.dto.response;

import com.vollmed.vollMed_api.model.Paciente;

public record DadosListagemPaciente(Long id, String nome, String cpf) {
    public DadosListagemPaciente(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getCpf());
    }
}
