package com.vollmed.vollMed_api.dto.response;

import com.vollmed.vollMed_api.model.Especialidade;
import com.vollmed.vollMed_api.model.Medico;

public record DadosDetalhamentoMedico(Long id, String nome, String email, String crm, Especialidade especialidade) {
    public DadosDetalhamentoMedico(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
