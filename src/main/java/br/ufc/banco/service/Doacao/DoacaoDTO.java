package br.ufc.banco.service.Doacao;

import br.ufc.banco.domain.Doador;
import br.ufc.banco.domain.enumareted.TipoSangue;
import jakarta.validation.constraints.NotNull;

public record DoacaoDTO(@NotNull Integer quantidade, @NotNull String cpf) {
}
