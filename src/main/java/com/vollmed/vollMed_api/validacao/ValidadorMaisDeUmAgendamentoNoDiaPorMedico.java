package com.vollmed.vollMed_api.validacao;

import com.vollmed.vollMed_api.exception.ValidacaoException;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMaisDeUmAgendamentoNoDiaPorMedico {

    public void validarConsulta(boolean existeMedico) {
        if (existeMedico) {
            throw new ValidacaoException("Não é permitido mais de um agendamento para um mesmo Médico em uma mesma data");
        }
    }
}
