package com.vollmed.vollMed_api.validacao;

import com.vollmed.vollMed_api.dto.request.DadosConsulta;
import com.vollmed.vollMed_api.exception.ValidacaoException;

import java.time.DayOfWeek;

public class ValidadorAgendamentoDomingo implements Validacoes {

    @Override
    public void validarConsulta(DadosConsulta dados) {
        var diaDaSemana = dados.dataConsulta().getDayOfWeek();
        if (diaDaSemana.equals(DayOfWeek.SUNDAY)) {
            throw new ValidacaoException("Não é permitido agendar consultas para um dia de domingo.");
        }
    }
}
