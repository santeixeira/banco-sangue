package br.ufc.banco.domain;

import br.ufc.banco.domain.enumareted.TipoSangue;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Estoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long estoqueId;
    @Column(name = "QUANTIDADE_A")
    private Integer quantidadeA;
    @Column(name = "QUANTIDADE_B")
    private Integer quantidadeB;
    @Column(name = "QUANTIDADE_O")
    private Integer quantidadeO;
    @Column(name = "QUANTIDADE_AB")
    private Integer quantidadeAB;



    public Estoque() {
    }

    public Estoque(Integer quantidadeA, Integer quantidadeB, Integer quantidadeO, Integer quantidadeAB) {
        this.quantidadeA = quantidadeA;
        this.quantidadeB = quantidadeB;
        this.quantidadeO = quantidadeO;
        this.quantidadeAB = quantidadeAB;
    }

    public Long getEstoqueId() {
        return estoqueId;
    }

    public void setEstoqueId(Long estoqueId) {
        this.estoqueId = estoqueId;
    }

    public Integer getQuantidadeA() {
        return quantidadeA;
    }

    public void setQuantidadeA(Integer quantidadeA) {
        this.quantidadeA = quantidadeA;
    }

    public Integer getQuantidadeB() {
        return quantidadeB;
    }

    public void setQuantidadeB(Integer quantidadeB) {
        this.quantidadeB = quantidadeB;
    }

    public Integer getQuantidadeO() {
        return quantidadeO;
    }

    public void setQuantidadeO(Integer quantidadeO) {
        this.quantidadeO = quantidadeO;
    }

    public Integer getQuantidadeAB() {
        return quantidadeAB;
    }

    public void setQuantidadeAB(Integer quantidadeAB) {
        this.quantidadeAB = quantidadeAB;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Estoque estoque)) return false;
        return Objects.equals(getEstoqueId(),
                estoque.getEstoqueId()) && Objects.equals(getQuantidadeA(),
                estoque.getQuantidadeA()) && Objects.equals(getQuantidadeB(),
                estoque.getQuantidadeB()) && Objects.equals(getQuantidadeO(),
                estoque.getQuantidadeO()) && Objects.equals(getQuantidadeAB(),
                estoque.getQuantidadeAB());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEstoqueId(), getQuantidadeA(), getQuantidadeB(), getQuantidadeO(), getQuantidadeAB());
    }
}
