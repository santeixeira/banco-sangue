package br.ufc.banco.service.Usuario;

import br.ufc.banco.domain.Usuario;
import br.ufc.banco.domain.enumareted.Cargos;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record UsuarioDTO(@NotNull @NotEmpty String email,
                         @NotNull @NotEmpty String senha,
                         @NotNull Cargos cargos) {

}
