package com.vollmed.vollMed_api.repository;

import com.vollmed.vollMed_api.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}