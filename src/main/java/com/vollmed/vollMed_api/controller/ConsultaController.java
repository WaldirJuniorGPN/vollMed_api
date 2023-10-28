package com.vollmed.vollMed_api.controller;

import com.vollmed.vollMed_api.dto.request.DadosCadastroConsulta;
import com.vollmed.vollMed_api.dto.response.DadosDetalhamentoConsulta;
import com.vollmed.vollMed_api.model.Consulta;
import com.vollmed.vollMed_api.repository.ConsultaRepository;
import com.vollmed.vollMed_api.repository.MedicoRepository;
import com.vollmed.vollMed_api.repository.PacienteRepository;
import com.vollmed.vollMed_api.service.ConsultaService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("consulta")
public class ConsultaController {

    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private ConsultaService consultaService;

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DadosCadastroConsulta dados, UriComponentsBuilder uriComponentsBuilder) {

        var paciente = this.pacienteRepository.findByIdAndAtivoTrue(dados.idPaciente()).orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado"));
        var medico = this.medicoRepository.findByIdAndAtivoTrue(dados.idMedico()).orElseThrow(() -> new EntityNotFoundException("Médico não encontrado"));
        var consulta = new Consulta(paciente, medico, dados.dataConsulta());

        this.consultaService.validarConsulta(consulta);

        var uri = uriComponentsBuilder.path("/consulta/{id}").buildAndExpand(consulta.getId()).toUri();

        this.consultaRepository.save(consulta);

        return ResponseEntity.created(uri).body(new DadosDetalhamentoConsulta(consulta));
    }
}
