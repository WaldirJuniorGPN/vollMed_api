package com.vollmed.vollMed_api.validacao;

import com.vollmed.vollMed_api.dto.request.DadosConsulta;
import com.vollmed.vollMed_api.exception.ValidacaoException;
import com.vollmed.vollMed_api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteInativo implements Validacoes {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public void validarConsulta(DadosConsulta dados) {
        var pacienteExiste = this.pacienteRepository.existsById(dados.idPaciente());
        var paciente = this.pacienteRepository.getReferenceById(dados.idPaciente());
        if (pacienteExiste && !paciente.isAtivo()) {
            throw new ValidacaoException("Não é permitido agendamentos com pacientes inativos");
        }
    }
}
