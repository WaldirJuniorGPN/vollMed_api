package com.vollmed.vollMed_api.dto.request;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPaciente(
        @NotNull
        Long id,
        String nome,
        String email,
        String telefone,
        String cpf,
        DadosAtualizacaoEndereco endereco
) {
}
