package br.ufc.banco.service.Banco;

import br.ufc.banco.domain.Endereco;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record BancoUpdateDTO(
    @NotNull @NotEmpty String nomeFantasia,
    @NotNull Endereco endereco
) {
}
