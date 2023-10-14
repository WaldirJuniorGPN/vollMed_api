package com.vollmed.vollMed_api.service;

import com.vollmed.vollMed_api.dto.request.DadosConsulta;
import com.vollmed.vollMed_api.model.Especialidade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class ConsultaServiceTest {

    private LocalDateTime horaAgendamentoAntesDoHorarioPermitido;
    private DadosConsulta dadosConsulta;
    @Autowired
    private ConsultaService consultaService;

    @BeforeEach
    void setUp() {


    }

    @Test
    void validaAgendamentoAntesDoHorarioPermitido() {
        this.horaAgendamentoAntesDoHorarioPermitido = LocalDateTime.of(2023, 10, 13,6, 29);
        this. dadosConsulta = new DadosConsulta(1L, 2L, Especialidade.CARDIOLOGIA, this.horaAgendamentoAntesDoHorarioPermitido);
//        this.consultaService.realizarAgendamentoConsulta(dadosConsulta);
    }
}