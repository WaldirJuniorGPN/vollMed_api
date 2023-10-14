package com.vollmed.vollMed_api.validacao;

import com.vollmed.vollMed_api.dto.request.DadosAgendamentoConsulta;
import com.vollmed.vollMed_api.exception.ValidacaoException;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoInativo implements Validacoes {

    @Override
    public void validarConsulta(DadosAgendamentoConsulta dados) {

        if (!dados.medico().isAtivo()) {
            throw new ValidacaoException("Não é permitido agendamentos com Médicos Inativos.");
        }
    }

}

