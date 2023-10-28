package com.vollmed.vollMed_api.service;

import com.vollmed.vollMed_api.model.Consulta;
import com.vollmed.vollMed_api.validations.Validacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {

    @Autowired
    private List<Validacao> validacoes;

    public void validarConsulta(Consulta consulta) {
        validacoes.forEach(validacao -> validacao.validarAgendamento(consulta));
    }
}
