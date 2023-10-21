package com.vollmed.vollMed_api.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosAtualizacaoPaciente(
        @NotNull
        Long id,
        String nome,
        @Pattern(regexp = "\\(\\d{2}\\)\\s\\d{4,5}-\\d{4}", message = "O telefone deve estar no formato (99) 99999-9999 ou (99) 9999-9999.")
        String telefone,
        @Valid
        DadosAtualizacaoEndereco endereco
) {
}
