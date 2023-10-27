package com.vollmed.vollMed_api.model;

import com.vollmed.vollMed_api.dto.request.DadosCadastroConsulta;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "consultas")
@Entity(name = "Consulta")
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;
    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;
    private LocalDateTime dataConsulta;

    public Consulta(Paciente paciente, Medico medico, LocalDateTime dataConsulta) {
        this.paciente = paciente;
        this.medico = medico;
        this.dataConsulta = dataConsulta;
    }
}
