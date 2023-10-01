package com.vollmed.vollMed_api.repository;

import com.vollmed.vollMed_api.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
}
