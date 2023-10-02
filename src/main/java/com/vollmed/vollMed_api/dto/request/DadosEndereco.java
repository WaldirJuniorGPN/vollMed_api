package com.vollmed.vollMed_api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(
        @NotBlank(message = "O Logradouro não pode estar em branco")
        String logradouro,
        Integer numero,
        String complemento,
        @NotBlank(message = "O Bairro não pode estar em branco")
        String bairro,
        @NotBlank(message = "A Cidade não pode estar em branco")
        String cidade,
        @NotBlank
        @Pattern(regexp = "^[A-Z]{2}$", message = "UF deve conter exatamente 2 letras maiúsculas")
        String uf,
        @NotBlank
        @Pattern(regexp = "^\\d{8}$", message = "CEP deve conter exatamente 8 dígitos")
        String cep
) {
}
