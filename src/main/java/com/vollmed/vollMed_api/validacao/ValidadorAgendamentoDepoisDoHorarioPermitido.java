package com.vollmed.vollMed_api.validacao;

import com.vollmed.vollMed_api.dto.request.DadosAgendamentoConsulta;
import com.vollmed.vollMed_api.exception.ValidacaoException;
import org.springframework.stereotype.Component;

@Component
public class ValidadorAgendamentoDepoisDoHorarioPermitido implements Validacoes {
    @Override
    public void validarConsulta(DadosAgendamentoConsulta dados) {
        var horaDaConsulta = dados.dataConsulta().getHour();
        if (horaDaConsulta > 18) {
            throw new ValidacaoException("Não é permitido agendar consultas para depois das 18:00 horas");
        }
    }
}
