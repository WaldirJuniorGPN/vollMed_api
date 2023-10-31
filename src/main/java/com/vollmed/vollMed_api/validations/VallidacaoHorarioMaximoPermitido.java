package com.vollmed.vollMed_api.validations;

import com.vollmed.vollMed_api.exception.ValidacaoException;
import com.vollmed.vollMed_api.model.Consulta;

public class VallidacaoHorarioMaximoPermitido implements Validacao {
    @Override
    public void validarAgendamento(Consulta consulta) {
        var horarioDaConsulta = consulta.getDataConsulta().getHour();
        if (horarioDaConsulta > 18) {
            throw new ValidacaoException("Nâo é permitido agendamento para depois das 18 horas.");
        }
    }
}
