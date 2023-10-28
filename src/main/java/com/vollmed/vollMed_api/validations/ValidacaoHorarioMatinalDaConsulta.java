package com.vollmed.vollMed_api.validations;

import com.vollmed.vollMed_api.exception.ValidacaoException;
import com.vollmed.vollMed_api.model.Consulta;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoHorarioMatinalDaConsulta implements Validacao {
    @Override
    public void validarAgendamento(Consulta consulta) {
        var horarioDaConsulta = consulta.getDataConsulta().getHour();
        if (horarioDaConsulta < 7) {
            throw new ValidacaoException("Nâo é permitido agendamento para antes das 7 horas da manhã.");
        }
    }
}
