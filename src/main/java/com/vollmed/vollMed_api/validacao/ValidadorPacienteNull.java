package com.vollmed.vollMed_api.validacao;

import com.vollmed.vollMed_api.dto.request.DadosConsulta;
import com.vollmed.vollMed_api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteNull implements Validacoes {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public void validarConsulta(DadosConsulta dados) {
        var pacienteExiste = this.pacienteRepository.existsById(dados.idPaciente());
        if (!pacienteExiste) {
            throw new NullPointerException("O ID do paciente fornecido não foi encontrado no Banco de Dados");
        }
    }
}
