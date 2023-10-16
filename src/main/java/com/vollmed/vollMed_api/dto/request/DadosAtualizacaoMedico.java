package com.vollmed.vollMed_api.dto.request;

import com.vollmed.vollMed_api.model.Especialidade;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosAtualizacaoMedico(
        @NotNull
        Long id,

        String nome,

        @Email(message = "O email deve ser um endereço de email válido.")
        String email,

        @Pattern(regexp = "\\(\\d{2}\\)\\s\\d{4,5}-\\d{4}", message = "O telefone deve estar no formato (99) 99999-9999 ou (99) 9999-9999.")
        String telefone,

        @Pattern(regexp = "^[0-9]{2}[.][0-9]{3}[.][0-9]{2}$", message = "O CRM deve estar no formato 99.999.99.")
        String crm,

        Especialidade especialidade,

        DadosAtualizacaoEndereco endereco
) {
}
