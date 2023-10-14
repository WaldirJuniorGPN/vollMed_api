package com.vollmed.vollMed_api.service;

import com.vollmed.vollMed_api.dto.request.DadosAgendamentoConsulta;
import com.vollmed.vollMed_api.model.Consulta;
import com.vollmed.vollMed_api.model.ConsultaCancelada;
import com.vollmed.vollMed_api.model.MotivoCancelamento;
import com.vollmed.vollMed_api.validacao.Validacoes;
import com.vollmed.vollMed_api.validacao.ValidadorCancelamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {

    @Autowired
    private List<Validacoes> validacoes;

    public Consulta realizarAgendamentoConsulta(DadosAgendamentoConsulta dados) {
        this.validacoes.forEach(validacoes -> validacoes.validarConsulta(dados));
        Consulta consulta = new Consulta(dados);

        return consulta;
    }

    public void realizarCancelamento(Consulta consulta, MotivoCancelamento motivo){
        new ValidadorCancelamentoConsulta(consulta);
        consulta.cancelarConsulta(consulta);
        new ConsultaCancelada(consulta, motivo);
    }

}
