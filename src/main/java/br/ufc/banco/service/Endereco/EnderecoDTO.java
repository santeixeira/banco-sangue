package br.ufc.banco.service.Endereco;

import br.ufc.banco.domain.enumareted.UF;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record EnderecoDTO(
        @NotNull @NotEmpty String logradouro,
        @NotNull Integer numero,
        @NotNull @NotEmpty String bairro,
        @NotNull @NotEmpty String cidade,
        @NotNull UF uf,
        @NotNull @NotEmpty String cep
        ) {
}
