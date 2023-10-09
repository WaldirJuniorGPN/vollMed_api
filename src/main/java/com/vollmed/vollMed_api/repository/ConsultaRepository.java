package com.vollmed.vollMed_api.repository;

import com.vollmed.vollMed_api.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    @Query("SELECT COUNT(c) > 0 FROM Consulta c " +
            "WHERE c.paciente.id = :pacienteId " +
            "AND c.dataConsulta = :dataConsulta")
    boolean existConsultaByPacienteAndDataConsulta(@Param("pacienteId") Long pacienteId, @Param("dataConsulta") LocalDateTime dataConsulta);

    @Query("SELECT COUNT(c) > 0 FROM Consulta c " +
            "WHERE c.medico.id = :medicoId " +
            "AND c.dataConsulta = :dataHoraConsulta")
    boolean existConsultaByMedicoAndDataConsulta(@Param("medicoId") Long medicoId, @Param("dataHoraConsulta") LocalDateTime dataHoraConsulta);

}
