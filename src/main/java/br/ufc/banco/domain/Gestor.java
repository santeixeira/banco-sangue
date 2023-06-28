package br.ufc.banco.domain;

import br.ufc.banco.domain.enumareted.TipoSangue;
import br.ufc.banco.domain.enumareted.UF;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name="GESTOR")
public class Gestor extends Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gestorId;
    private Banco banco;

    public Gestor() {
    }

    public Gestor(String nome, TipoSangue tipoSangue, String cpf, String telefone, LocalDateTime dataNascimento, UF naturalidade, Endereco endereco, Long funcionarioId, BigDecimal salario, String setor, LocalDateTime dataAdmissao, Usuario usuario, Long gestorId) {
        super(nome, tipoSangue, cpf, telefone, dataNascimento, naturalidade, endereco, funcionarioId, salario, setor, dataAdmissao, usuario);
        this.gestorId = gestorId;
    }

    public Long getGestorId() {
        return gestorId;
    }

    public void setGestorId(Long gestorId) {
        this.gestorId = gestorId;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Gestor gestor)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getGestorId(), gestor.getGestorId()) && Objects.equals(getBanco(), gestor.getBanco());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getGestorId(), getBanco());
    }
}
