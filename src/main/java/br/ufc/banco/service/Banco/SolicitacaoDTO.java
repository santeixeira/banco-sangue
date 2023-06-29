package br.ufc.banco.service.Banco;

import br.ufc.banco.domain.enumareted.Status;
import br.ufc.banco.domain.enumareted.TipoSangue;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record SolicitacaoDTO(
        @NotNull Integer quantidade,
        @NotNull TipoSangue tipoSangue,
        @NotNull Long bancoId
) {
}
