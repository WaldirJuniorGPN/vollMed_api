package com.vollmed.vollMed_api.dto.request;

import com.vollmed.vollMed_api.model.Medico;
import com.vollmed.vollMed_api.model.Paciente;

import java.time.LocalDate;

public record DadosAgendamentoConsulta(Paciente paciente, Medico medico, LocalDate dataConsulta) {
}
