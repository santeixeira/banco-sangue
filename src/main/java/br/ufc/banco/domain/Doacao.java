package br.ufc.banco.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Doacao {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doacaoId;
    private Integer quantidade;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doadorId", referencedColumnName = "doadorId")
    private Doador doador;

    public Doacao () {}

    public Doacao(Long doacaoId, Integer quantidade, Doador doador) {
        this.doacaoId = doacaoId;
        this.quantidade = quantidade;
        this.doador = doador;
    }

    public Long getDoacaoId() {
        return doacaoId;
    }

    public void setDoacaoId(Long doacaoId) {
        this.doacaoId = doacaoId;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Doador getDoador() {
        return doador;
    }

    public void setDoador(Doador doador) {
        this.doador = doador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Doacao doacao)) return false;
        return Objects.equals(getDoacaoId(), doacao.getDoacaoId()) && Objects.equals(getQuantidade(), doacao.getQuantidade()) && Objects.equals(getDoador(), doacao.getDoador());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDoacaoId(), getQuantidade(), getDoador());
    }
}
