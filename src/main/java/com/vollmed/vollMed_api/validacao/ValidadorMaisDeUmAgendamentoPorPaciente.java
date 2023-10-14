package com.vollmed.vollMed_api.validacao;

import com.vollmed.vollMed_api.exception.ValidacaoException;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMaisDeUmAgendamentoPorPaciente {

    public void validarConsulta(boolean existeConsulta) {
        if (existeConsulta) {
            throw new ValidacaoException("Não é permitido que um Paciente tenha mais de uma consulta para o mesmo dia.");
        }
    }
}
