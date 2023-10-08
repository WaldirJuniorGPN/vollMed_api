package com.vollmed.vollMed_api.validacao;

import com.vollmed.vollMed_api.dto.request.DadosConsulta;
import com.vollmed.vollMed_api.exception.ValidacaoException;
import org.springframework.stereotype.Component;

@Component
public class ValidadorAgendamentoAntesDoHorarioPermitido implements Validacoes {

    @Override
    public void validarConsulta(DadosConsulta dados) {
        var horaDaConsulta = dados.dataConsulta().getHour();
        if (horaDaConsulta < 7) {
            throw new ValidacaoException("Não é permitido agendamentos para antes das 7 horas da manhã.");
        }
    }
}
