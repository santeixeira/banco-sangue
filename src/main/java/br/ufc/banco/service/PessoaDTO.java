package br.ufc.banco.service;

import br.ufc.banco.domain.Endereco;
import br.ufc.banco.domain.enumareted.TipoSangue;
import br.ufc.banco.domain.enumareted.UF;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDateTime;

public record PessoaDTO (
        @NotNull @NotEmpty String nome,
        @NotNull @NotEmpty TipoSangue tipoSangue,
        @NotNull @NotEmpty @CPF String cpf,
        @NotNull @NotEmpty String telefone,
        LocalDateTime dataNascimento,
        @NotNull @NotEmpty UF naturalidade,
        @NotNull @NotEmpty Endereco endereco
){
}
