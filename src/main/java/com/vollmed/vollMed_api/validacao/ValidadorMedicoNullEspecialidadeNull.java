package com.vollmed.vollMed_api.validacao;

import com.vollmed.vollMed_api.dto.request.DadosConsulta;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoNullEspecialidadeNull implements Validacoes {

    @Override
    public void validarConsulta(DadosConsulta dados) {
        if (dados.idMedico() == null && dados.especialidade() == null) {
            throw new NullPointerException("Para efetuar um agendamento é necessário informar, ao menos, a especialidade do médico, caso contrário, informe o seu ID");
        }
    }
}
