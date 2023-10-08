package com.vollmed.vollMed_api.model;

import com.vollmed.vollMed_api.dto.request.DadosAgendamentoConsulta;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "Consulta")
@Table(name = "consultas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dataDaConsulta;
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;
    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;

    public Consulta(DadosAgendamentoConsulta dados) {
        this.dataDaConsulta = dados.dataConsulta();
        this.paciente = dados.paciente();
        this.medico = dados.medico();
    }
}
