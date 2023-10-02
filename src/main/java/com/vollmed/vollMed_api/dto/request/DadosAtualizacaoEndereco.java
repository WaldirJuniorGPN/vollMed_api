package com.vollmed.vollMed_api.dto.request;

public record DadosAtualizacaoEndereco(
        String logradouro,
        Integer numero,
        String complemento,
        String bairro,
        String cidade,
        String uf,
        String cep
) {
}
