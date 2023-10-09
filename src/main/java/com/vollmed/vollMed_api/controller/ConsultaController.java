package com.vollmed.vollMed_api.controller;

import com.vollmed.vollMed_api.dto.request.DadosCancelamentoConsulta;
import com.vollmed.vollMed_api.dto.request.DadosConsulta;
import com.vollmed.vollMed_api.dto.response.DadosDetalhamentoConsulta;
import com.vollmed.vollMed_api.dto.response.DadosListagemConsulta;
import com.vollmed.vollMed_api.repository.ConsultaRepository;
import com.vollmed.vollMed_api.service.ConsultaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("consulta")
public class ConsultaController {
    @Autowired
    private ConsultaRepository repository;
    @Autowired
    private ConsultaService consultaService;

    @PostMapping
    @Transactional
    public ResponseEntity agendarConsulta(@Valid @RequestBody DadosConsulta dados, UriComponentsBuilder uriComponentsBuilder) {
        var consulta = this.consultaService.realizarAgendamentoConsulta(dados);
        this.repository.save(consulta);
        var uri = uriComponentsBuilder.path("/consulta/{id}").buildAndExpand(consulta.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoConsulta(consulta));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemConsulta>> listarConsultas(Pageable paginacao) {
        var page = this.repository.findAll(paginacao).map(DadosListagemConsulta::new);
        return ResponseEntity.ok(page);
    }

    @DeleteMapping()
    @Transactional
    public ResponseEntity cancelarConsulta(@RequestBody @Valid DadosCancelamentoConsulta dados) {
        var consulta = this.repository.getReferenceById(id);
        consulta.cancelarConsulta();
        return ResponseEntity.noContent().build();
    }

}
