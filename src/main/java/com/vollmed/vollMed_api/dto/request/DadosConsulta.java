package com.vollmed.vollMed_api.dto.request;

import com.vollmed.vollMed_api.model.Especialidade;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosConsulta(
        @NotNull
        Long idPaciente,
        Long idMedico,
        Especialidade especialidade,
        @Future
        @NotNull
        LocalDateTime dataConsulta
) {
}
