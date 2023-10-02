package com.vollmed.vollMed_api.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroPaciente(
        @NotBlank(message = "O nome é obrigatório")
        @Pattern(regexp = "^[A-Za-zÀ-ÖØ-öø-ÿ\\s]*$", message = "Nome inválido")
        String nome,

        @NotBlank(message = "O email é obrigatório")
        @Email(message = "Email inválido")
        String email,

        @NotBlank(message = "O telefone é obrigatório")
        @Pattern(regexp = "^\\(?(\\d{2,3})\\)?[-.\\s]?(\\d{4,5})[-.\\s]?(\\d{4})$", message = "Telefone inválido")
        String telefone,

        @NotBlank(message = "O CPF é obrigatório")
        @Pattern(regexp = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$", message = "CPF inválido")
        String cpf,

        @NotNull(message = "O endereço é obrigatório")
        DadosEndereco endereco
) {
}
