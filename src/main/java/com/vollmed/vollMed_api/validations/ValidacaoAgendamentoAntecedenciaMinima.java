package com.vollmed.vollMed_api.validations;

import com.vollmed.vollMed_api.exception.ValidacaoException;
import com.vollmed.vollMed_api.model.Consulta;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ValidacaoAgendamentoAntecedenciaMinima implements Validacao {
    @Override
    public void validarAgendamento(Consulta consulta) {
        var dataAtual = LocalDateTime.now();
        var dataConsulta = consulta.getDataConsulta();

        var dataMinimaPermitida = dataConsulta.minusMinutes(30);

        if (dataAtual.isBefore(dataMinimaPermitida)) {
            throw new ValidacaoException("A consulta deve ser agendada com pelo menos 30 minutos de antecedência.");
        }
    }
}
