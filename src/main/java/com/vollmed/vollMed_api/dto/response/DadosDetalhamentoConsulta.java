package com.vollmed.vollMed_api.dto.response;

import com.vollmed.vollMed_api.model.Consulta;

import java.time.LocalDateTime;

public record DadosDetalhamentoConsulta(Long id, LocalDateTime dataConsulta, Long idPaciente, String nomePaciente,
                                        Long idMedico, String nomeMedico) {
    public DadosDetalhamentoConsulta(Consulta consulta) {
        this(consulta.getId(), consulta.getDataDaConsulta(), consulta.getPaciente().getId(), consulta.getPaciente().getNome(), consulta.getMedico().getId(), consulta.getMedico().getNome());
    }
}
