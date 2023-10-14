package com.vollmed.vollMed_api.validacao;

import com.vollmed.vollMed_api.dto.request.DadosAgendamentoConsulta;
import com.vollmed.vollMed_api.dto.request.DadosConsulta;
import com.vollmed.vollMed_api.exception.ValidacaoException;
import com.vollmed.vollMed_api.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMaisDeUmAgendamentoPorPaciente implements Validacoes {

    @Override
    public void validarConsulta(DadosAgendamentoConsulta dados) {

        var existeConsultaNaMesmaDataMesmoPaciente = this.consultaRepository.existConsultaByPacienteAndDataConsulta(dados.idPaciente(), dados.dataConsulta());

        if (existeConsultaNaMesmaDataMesmoPaciente) {
            throw new ValidacaoException("Não é permitido que um Paciente tenha mais de uma consulta para o mesmo dia.");
        }
    }
}
