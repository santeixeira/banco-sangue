package br.ufc.banco.service.Funcionario;

import jakarta.validation.constraints.NotNull;

public record GestorDTO(
        @NotNull Long funcionarioId,
        @NotNull Long bancoId
) {
}
