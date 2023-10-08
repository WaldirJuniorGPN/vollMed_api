package com.vollmed.vollMed_api.dto.request;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosConsulta(
        @NotNull
        Long idPaciente,
        @NotNull
        Long idMedico,
        @Future
        LocalDateTime dataConsulta
) {
}
