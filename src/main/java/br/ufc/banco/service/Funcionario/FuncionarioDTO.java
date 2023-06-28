package br.ufc.banco.service.Funcionario;

import br.ufc.banco.domain.Endereco;
import br.ufc.banco.domain.Usuario;
import br.ufc.banco.domain.enumareted.TipoSangue;
import br.ufc.banco.domain.enumareted.UF;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jdk.jfr.Timestamp;
import org.hibernate.validator.constraints.br.CPF;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record FuncionarioDTO (
        @NotNull @NotEmpty String nome,
        @NotNull TipoSangue tipoSangue,
        @NotNull @CPF String cpf,
        @NotNull @NotEmpty String telefone,
        LocalDateTime dataNascimento,
        @NotNull UF naturalidade,
        @NotNull Endereco endereco,
        BigDecimal salario,
        @NotNull @NotEmpty String setor,
        @NotNull @Timestamp LocalDateTime dataAdmissao,
        @NotNull Long usuarioId) {
}
