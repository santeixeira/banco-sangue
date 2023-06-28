package br.ufc.banco.service.Banco;

import br.ufc.banco.domain.Endereco;
import br.ufc.banco.domain.Estoque;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record BancoDTO(
        @NotNull @NotEmpty String nomeFantasia,
        @NotNull Endereco endereco,
        @NotNull Estoque estoque
) {
}
