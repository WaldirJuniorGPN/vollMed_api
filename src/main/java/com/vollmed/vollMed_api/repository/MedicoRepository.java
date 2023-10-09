package com.vollmed.vollMed_api.repository;

import com.vollmed.vollMed_api.model.Especialidade;
import com.vollmed.vollMed_api.model.Medico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Page<Medico> findAllByAtivoTrue(Pageable paginacao);

    @Query("""
                SELECT m
                FROM Medico m
                WHERE m.ativo = true
                AND m.especialidade = :especialidade
                AND NOT EXISTS (
                    SELECT c
                    FROM Consulta c
                    WHERE c.medico = m
                    AND c.data = :data
                )
                ORDER BY FUNCTION('RAND')
            """)
    Medico escolherMedicoAleatorioLivreNaData(@Param("especialidade") Especialidade especialidade, @Param("data") LocalDateTime data);
}
