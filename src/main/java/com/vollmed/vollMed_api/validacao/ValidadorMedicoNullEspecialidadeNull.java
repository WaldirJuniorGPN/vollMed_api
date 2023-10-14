package com.vollmed.vollMed_api.validacao;

import com.vollmed.vollMed_api.dto.request.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoNullEspecialidadeNull implements Validacoes {

    @Override
    public void validarConsulta(DadosAgendamentoConsulta dados) {
        if (dados.medico() == null && dados.especialidade() == null) {
            throw new NullPointerException("Para efetuar um agendamento é necessário informar, ao menos, a especialidade do médico, caso contrário, informe o seu ID");
        }
    }
}
