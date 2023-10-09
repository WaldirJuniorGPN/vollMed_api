package com.vollmed.vollMed_api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCancelamentoConsulta(
        @NotNull
        Long id,
        @NotBlank(message = "Para cancelar uma consulta é necessário informar o motivo")
        String motivoCancelamento
) {
}
