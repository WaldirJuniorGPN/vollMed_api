package com.vollmed.vollMed_api.dto.request;

import com.vollmed.vollMed_api.model.MotivoCancelamento;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCancelamentoConsulta(
        @NotNull
        Long id,
        @NotBlank(message = "Para cancelar uma consulta é necessário informar o motivo")
        MotivoCancelamento motivoCancelamento
) {
}
