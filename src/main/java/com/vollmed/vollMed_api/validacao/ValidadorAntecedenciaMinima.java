package com.vollmed.vollMed_api.validacao;

import com.vollmed.vollMed_api.dto.request.DadosAgendamentoConsulta;
import com.vollmed.vollMed_api.exception.ValidacaoException;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ValidadorAntecedenciaMinima implements Validacoes {
    @Override
    public void validarConsulta(DadosAgendamentoConsulta dados) {
        var dataConsulta = dados.dataConsulta();
        var agora = LocalDateTime.now();
        var limiteMinimo = agora.plusMinutes(30);

        if (dataConsulta.isBefore(limiteMinimo)) {
            throw new ValidacaoException("Não é permitido agendamentos com menos de 30 minutos de antecedência");
        }
    }
}
