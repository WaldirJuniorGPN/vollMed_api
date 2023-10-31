package com.vollmed.vollMed_api.validations;

import com.vollmed.vollMed_api.exception.ValidacaoException;
import com.vollmed.vollMed_api.model.Consulta;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class ValidacaoDiaDaSemana implements Validacao {
    @Override
    public void validarAgendamento(Consulta consulta) {
        var diaDaConsulta = consulta.getDataConsulta().getDayOfWeek();

        if (diaDaConsulta.equals(DayOfWeek.SUNDAY)) {
            throw new ValidacaoException("Não é possível agendar consultas para o domingo.");
        }
    }
}
