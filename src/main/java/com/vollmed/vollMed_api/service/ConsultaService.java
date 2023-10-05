package com.vollmed.vollMed_api.service;

import com.vollmed.vollMed_api.dto.request.DadosAgendamentoConsulta;
import com.vollmed.vollMed_api.dto.request.DadosConsulta;
import com.vollmed.vollMed_api.model.Medico;
import com.vollmed.vollMed_api.model.Paciente;
import com.vollmed.vollMed_api.repository.MedicoRepository;
import com.vollmed.vollMed_api.repository.PacienteRepository;
import com.vollmed.vollMed_api.validacao.Validacoes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ConsultaService {

    private LocalDate dataConsulta;
    private Paciente paciente;
    private Medico medico;
    private List<Validacoes> validacoes;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private MedicoRepository medicoRepository;

    public void realizarAgendamentoConsulta(DadosConsulta dados) {
        var paciente = this.pacienteRepository.getReferenceById(dados.idPaciente());
        var medico = this.medicoRepository.getReferenceById(dados.idMedico());
        DadosAgendamentoConsulta dto = new DadosAgendamentoConsulta(paciente, medico, this.dataConsulta);
    }
}
