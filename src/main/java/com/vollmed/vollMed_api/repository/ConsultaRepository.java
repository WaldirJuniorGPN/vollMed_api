package com.vollmed.vollMed_api.repository;

import com.vollmed.vollMed_api.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    Consulta findByPacienteIdAndDataConsulta(Long id, LocalDateTime data);
    Consulta findByMedicoIdAndDataConsulta(Long id, LocalDateTime data);
}
