package com.vollmed.vollMed_api.validacao;

import com.vollmed.vollMed_api.dto.request.DadosAgendamentoConsulta;
import com.vollmed.vollMed_api.exception.ValidacaoException;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMaisDeUmAgendamentoNoDiaPorMedico implements Validacoes {

    @Override
    public void validarConsulta(DadosAgendamentoConsulta consulta) {
        var existeConsultaNoMesmoDiaParaOMesmoMedico = this.consultaRepository.existConsultaByMedicoAndDataConsulta(consulta.idMedico(), consulta.dataConsulta());
        if(existeConsultaNoMesmoDiaParaOMesmoMedico){
            throw new ValidacaoException("Não é permitido mais de um agendamento para um mesmo Médico em uma mesma data");
        }
    }
}
