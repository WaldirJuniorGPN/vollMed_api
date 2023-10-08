package com.vollmed.vollMed_api.validacao;

import com.vollmed.vollMed_api.dto.request.DadosConsulta;
import com.vollmed.vollMed_api.exception.ValidacaoException;
import com.vollmed.vollMed_api.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMaisDeUmAgendamentoNoDiaPorMedico implements Validacoes {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Override
    public void validarConsulta(DadosConsulta dados) {
        var existeConsultaNoMesmoDiaParaOMesmoMedico = this.consultaRepository.existConsultaByMedicoAndDataConsulta(dados.idMedico(), dados.dataConsulta());
        if(existeConsultaNoMesmoDiaParaOMesmoMedico){
            throw new ValidacaoException("Não é permitido mais de um agendamento para um mesmo Médico em uma mesma data");
        }
    }
}
