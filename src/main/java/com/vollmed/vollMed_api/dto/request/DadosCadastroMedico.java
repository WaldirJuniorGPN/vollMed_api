package com.vollmed.vollMed_api.dto.request;

import com.vollmed.vollMed_api.model.Endereco;
import com.vollmed.vollMed_api.model.Especialidade;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroMedico(
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @NotNull
        String telefone,
        @NotNull
        String crm,
        @NotBlank
        Especialidade especialidade,
        DadosEndereco endereco
) {
}
