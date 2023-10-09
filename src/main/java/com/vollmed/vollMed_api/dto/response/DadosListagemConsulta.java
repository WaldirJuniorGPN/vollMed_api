package com.vollmed.vollMed_api.dto.response;

import com.vollmed.vollMed_api.model.Consulta;
import com.vollmed.vollMed_api.model.Especialidade;

import java.time.LocalDateTime;

public record DadosListagemConsulta(Long id, String nomePaciente, String nomeMedico, Especialidade especialidade,
                                    LocalDateTime dataConsulta) {
    public DadosListagemConsulta(Consulta consulta) {
        this(consulta.getId(), consulta.getPaciente().getNome(), consulta.getMedico().getNome(), consulta.getMedico().getEspecialidade(), consulta.getDataDaConsulta());
    }
}
