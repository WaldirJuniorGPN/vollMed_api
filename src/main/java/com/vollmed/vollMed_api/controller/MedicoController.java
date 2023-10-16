package com.vollmed.vollMed_api.controller;

import com.vollmed.vollMed_api.dto.request.DadosAtualizacaoMedico;
import com.vollmed.vollMed_api.dto.request.DadosCadastroMedico;
import com.vollmed.vollMed_api.dto.response.DadosDetalhamentoMedico;
import com.vollmed.vollMed_api.dto.response.DadosListagemMedico;
import com.vollmed.vollMed_api.model.Medico;
import com.vollmed.vollMed_api.repository.MedicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("medico")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMedico dados, UriComponentsBuilder uriComponentsBuilder) {
        var medico = new Medico(dados);
        var uri = uriComponentsBuilder.path("medico/{id}").buildAndExpand(medico.getId()).toUri();
        this.repository.save(medico);
        return ResponseEntity.created(uri).body(new DadosDetalhamentoMedico(medico));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemMedico>> listar(Pageable paginacao) {
        var page = this.repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados) {
        var medico = this.repository.getReferenceById(dados.id());
        medico.atualizarMedico(dados);
        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id) {
        var medico = this.repository.getReferenceById(id);
        medico.desativar();
        return ResponseEntity.noContent().build();
    }
}
