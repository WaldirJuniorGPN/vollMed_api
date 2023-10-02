package com.vollmed.vollMed_api.dto.request;

import com.vollmed.vollMed_api.model.Especialidade;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoMedico(
        @NotNull
        Long id,
        String nome,
        String email,
        String telefone,
        String crm,
        Especialidade especialidade,
        DadosAtualizacaoEndereco endereco
) {
}
