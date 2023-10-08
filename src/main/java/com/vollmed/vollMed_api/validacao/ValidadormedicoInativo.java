package com.vollmed.vollMed_api.validacao;

import com.vollmed.vollMed_api.dto.request.DadosConsulta;
import com.vollmed.vollMed_api.exception.ValidacaoException;
import com.vollmed.vollMed_api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadormedicoInativo implements Validacoes {

    @Autowired
    private MedicoRepository medicoRepository;

    @Override
    public void validarConsulta(DadosConsulta dados) {
        var medicoExiste = this.medicoRepository.existsById(dados.idMedico());
        var medico = this.medicoRepository.getReferenceById(dados.idMedico());

        if (medicoExiste && !medico.isAtivo()) {
            throw new ValidacaoException("Não é permitido agendamentos com Médicos Inativos.");
        }
    }
}
