package br.ufc.banco.service.Banco;

import jakarta.validation.constraints.NotNull;

public record EnvioSolicitacaoDTO(
    @NotNull Long bancoReceberId,
    @NotNull Long bancoEnviarId
) {
}
