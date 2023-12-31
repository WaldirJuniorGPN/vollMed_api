package com.vollmed.vollMed_api.dto.request;

import com.vollmed.vollMed_api.model.Especialidade;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroMedico(
        @NotBlank(message = "O nome é obrigatório")
        @Pattern(regexp = "^[A-Za-zÀ-ÖØ-öø-ÿ\\s]*$", message = "Nome inválido")
        String nome,

        @NotBlank(message = "O email é obrigatório")
        @Email(message = "Email inválido")
        String email,

        @NotNull(message = "O telefone é obrigatório")
        @Pattern(regexp = "^\\(?(\\d{2,3})\\)?[-.\\s]?(\\d{4,5})[-.\\s]?(\\d{4})$", message = "Telefone inválido")
        String telefone,

        @NotNull(message = "O CRM é obrigatório")
        @Pattern(regexp = "^\\d{2}\\.\\d{2,4}$", message = "CRM inválido")
        String crm,

        @NotBlank(message = "A especialidade é obrigatória")
        Especialidade especialidade,

        DadosEndereco endereco
) {
}
