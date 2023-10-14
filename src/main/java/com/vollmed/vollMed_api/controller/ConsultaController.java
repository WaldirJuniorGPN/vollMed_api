package com.vollmed.vollMed_api.controller;

import com.vollmed.vollMed_api.dto.request.DadosAgendamentoConsulta;
import com.vollmed.vollMed_api.dto.request.DadosCancelamentoConsulta;
import com.vollmed.vollMed_api.dto.request.DadosConsulta;
import com.vollmed.vollMed_api.dto.response.DadosDetalhamentoConsulta;
import com.vollmed.vollMed_api.dto.response.DadosListagemConsulta;
import com.vollmed.vollMed_api.model.Medico;
import com.vollmed.vollMed_api.model.Paciente;
import com.vollmed.vollMed_api.repository.ConsultaRepository;
import com.vollmed.vollMed_api.repository.MedicoRepository;
import com.vollmed.vollMed_api.repository.PacienteRepository;
import com.vollmed.vollMed_api.service.ConsultaService;
import jakarta.persistence.EntityNotFoundException;
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
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private MedicoRepository medicoRepository;
    private DadosAgendamentoConsulta dadosAgendamentoConsulta;

    @PostMapping
    @Transactional
    public ResponseEntity agendarConsulta(@Valid @RequestBody DadosConsulta dados, UriComponentsBuilder uriComponentsBuilder) {
        var paciente = buscaPaciente(dados.idPaciente());
        var medico = buscaMedico(dados);
        this.dadosAgendamentoConsulta = new DadosAgendamentoConsulta(paciente, medico,dados.especialidade(),dados.dataConsulta());
        var consulta = this.consultaService.realizarAgendamentoConsulta(dadosAgendamentoConsulta);
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
        var consulta = this.repository.getReferenceById(dados.id());
        this.consultaService.realizarCancelamento(consulta, dados.motivoCancelamento());
        return ResponseEntity.noContent().build();
    }

    private Paciente buscaPaciente(Long id) {
        try {
            var paciente = this.pacienteRepository.getReferenceById(id);
            return paciente;
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    private Medico buscaMedico(DadosConsulta dados) {

        var medico = (dados.idMedico() == null) ?
                this.medicoRepository.escolherMedicoAleatorioLivreNaData(dados.especialidade(), dados.dataConsulta()) :
                buscaMedicoTratado(dados.idMedico());
        return medico;
    }

    private Medico buscaMedicoTratado(Long id) {
        try {
            var medico = this.medicoRepository.getReferenceById(id);
            return medico;
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

}
