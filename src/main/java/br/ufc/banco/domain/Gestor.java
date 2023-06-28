package br.ufc.banco.domain;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class Gestor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gestorId;

    @OneToOne
    @JoinColumn(name = "funcionarioId", referencedColumnName = "funcionarioId")
    private Funcionario funcionario;

    @OneToOne
    @JoinColumn(name = "bancoId", referencedColumnName = "bancoId")
    private Banco banco;

    public Gestor() {
    }

    public Gestor(Funcionario funcionario, Banco banco) {
        this.funcionario = funcionario;
        this.banco = banco;
    }

    public Long getGestorId() {
        return gestorId;
    }

    public void setGestorId(Long gestorId) {
        this.gestorId = gestorId;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
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
        return Objects.equals(getBanco(), gestor.getBanco());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getBanco());
    }
}
