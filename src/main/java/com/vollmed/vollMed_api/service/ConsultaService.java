package com.vollmed.vollMed_api.service;

import com.vollmed.vollMed_api.dto.request.DadosAgendamentoConsulta;
import com.vollmed.vollMed_api.dto.request.DadosConsulta;
import com.vollmed.vollMed_api.model.Consulta;
import com.vollmed.vollMed_api.model.Medico;
import com.vollmed.vollMed_api.repository.MedicoRepository;
import com.vollmed.vollMed_api.repository.PacienteRepository;
import com.vollmed.vollMed_api.validacao.Validacoes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {

    private List<Validacoes> validacoes;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private MedicoRepository medicoRepository;
    private Medico medico;

    public Consulta realizarAgendamentoConsulta(DadosConsulta dados) {

        this.validacoes.forEach(validacoes -> validacoes.validarConsulta(dados));

        this.medico = (dados.idMedico() == null) ?
                this.medicoRepository.escolherMedicoAleatorioLivreNaData(dados.especialidade(), dados.dataConsulta()) :
                this.medicoRepository.getReferenceById(dados.idMedico());

        var paciente = this.pacienteRepository.getReferenceById(dados.idPaciente());
        var especialidade = dados.especialidade();
        var dataConsulta = dados.dataConsulta();


        DadosAgendamentoConsulta dto = new DadosAgendamentoConsulta(paciente, medico, especialidade, dataConsulta);
        Consulta consulta = new Consulta(dto);

        return consulta;
    }

}
