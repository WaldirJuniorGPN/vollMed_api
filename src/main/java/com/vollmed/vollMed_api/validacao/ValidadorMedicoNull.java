package com.vollmed.vollMed_api.validacao;

import com.vollmed.vollMed_api.dto.request.DadosConsulta;
import com.vollmed.vollMed_api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoNull implements Validacoes{

    @Autowired
    private MedicoRepository medicoRepository;
    @Override
    public void validarConsulta(DadosConsulta dados) {
        var medicoExiste = this.medicoRepository.existsById(dados.idMedico());
        if (!medicoExiste) {
            throw new NullPointerException("O ID do Médico fornecido não encontrado no Banco de Dados");
        }
    }
}
