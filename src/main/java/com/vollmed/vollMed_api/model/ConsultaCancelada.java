package com.vollmed.vollMed_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "ConsultaCancelada")
@Table(name = "consultas_canceladas")
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class ConsultaCancelada {
    @Id
    private Long id;
    private LocalDateTime dataConsulta;
    private Paciente paciente;
    private Medico medico;
    private MotivoCancelamento motivoCancelamento;

    public ConsultaCancelada(Consulta consulta, MotivoCancelamento motivo) {
        this.id = consulta.getId();
        this.dataConsulta = consulta.getDataDaConsulta();
        this.paciente = consulta.getPaciente();
        this.medico = consulta.getMedico();
        this.motivoCancelamento = motivo;
    }
}
