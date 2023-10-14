package com.vollmed.vollMed_api.validacao;

import com.vollmed.vollMed_api.dto.request.DadosAgendamentoConsulta;
import com.vollmed.vollMed_api.exception.ValidacaoException;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidadorAgendamentoDomingo implements Validacoes {

    @Override
    public void validarConsulta(DadosAgendamentoConsulta dados) {
        var diaDaSemana = dados.dataConsulta().getDayOfWeek();
        if (diaDaSemana.equals(DayOfWeek.SUNDAY)) {
            throw new ValidacaoException("Não é permitido agendar consultas para um dia de domingo.");
        }
    }
}
