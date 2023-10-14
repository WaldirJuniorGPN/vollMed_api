package com.vollmed.vollMed_api.validacao;

import com.vollmed.vollMed_api.exception.ValidacaoException;
import com.vollmed.vollMed_api.model.Consulta;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ValidadorCancelamentoConsulta {
    public ValidadorCancelamentoConsulta(Consulta consulta){
        var dataConsulta = consulta.getDataDaConsulta();
        var dataAtual = LocalDateTime.now();
        var limite = dataConsulta.plusHours(24);

        if(dataAtual.isBefore(limite)){
            throw new ValidacaoException("Só é permiitdo cancelar a consulta em até 24 horas");
        }
    }
}
