package com.vollmed.vollMed_api.controller;

import com.vollmed.vollMed_api.dto.request.DadosConsulta;
import com.vollmed.vollMed_api.repository.ConsultaRepository;
import com.vollmed.vollMed_api.service.ConsultaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.util.UriComponentsBuilder;

public class ConsultaController {
    @Autowired
    private ConsultaRepository repository;
    @Autowired
    private ConsultaService consultaService;

    @PostMapping
    @Transactional
    public ResponseEntity agendarConsulta(DadosConsulta dados, UriComponentsBuilder uriComponentsBuilder) {
        this.consultaService.realizarAgendamentoConsulta(dados);
        return null;
    }
}
