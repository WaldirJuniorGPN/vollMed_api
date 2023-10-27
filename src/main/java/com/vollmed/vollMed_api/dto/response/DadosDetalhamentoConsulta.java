package com.vollmed.vollMed_api.dto.response;

import com.vollmed.vollMed_api.model.Consulta;

import java.time.LocalDateTime;

public record DadosDetalhamentoConsulta(Long idConsulta, Long idMedico, Long idPaciente, LocalDateTime dataConsulta) {
    public DadosDetalhamentoConsulta(Consulta consulta) {
        this(consulta.getId(), consulta.getMedico().getId(), consulta.getPaciente().getId(), consulta.getDataConsulta());
    }
}
