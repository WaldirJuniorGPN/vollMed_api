package com.vollmed.vollMed_api.service;

import com.vollmed.vollMed_api.exception.ValidacaoException;
import com.vollmed.vollMed_api.model.Consulta;
import com.vollmed.vollMed_api.validations.Validacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {

    @Autowired
    private List<Validacao> validacoes;

    public void validarConsultas(Consulta consultaMedico, Consulta consultaPaciente, Consulta consultaAtual) {
        var dataConsultaPaciente = consultaPaciente.getDataConsulta().toLocalDate();
        var dataConsultaAtual = consultaAtual.getDataConsulta().toLocalDate();

        if (consultaMedico.getDataConsulta().equals(consultaAtual.getDataConsulta())) {
            throw new ValidacaoException("O Médico já possui uma consulta agendada para esse horário");
        }

        if (dataConsultaAtual.equals(dataConsultaPaciente)) {
            throw new ValidacaoException("Não é permitido que um paciente agende mais de uma consulta para o mesmo dia");
        }

        validacoes.forEach(validacao -> validacao.validarAgendamento(consultaAtual));
    }

}
