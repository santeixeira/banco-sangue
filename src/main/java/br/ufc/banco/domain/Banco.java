package br.ufc.banco.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Banco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bancoId;
    private String nomeFantasia;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "enderecoId", referencedColumnName = "enderecoId")
    private Endereco endereco;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "estoqueId", referencedColumnName = "estoqueId")
    private Estoque estoque;
    @OneToOne
    @JoinColumn(name = "gestorId")
    private Gestor gestor;

    public Banco() {
    }

    public Banco(String nomeFantasia, Endereco endereco, Estoque estoque, Gestor gestor) {
        this.nomeFantasia = nomeFantasia;
        this.endereco = endereco;
        this.estoque = estoque;
        this.gestor = gestor;
    }

    public Long getBancoId() {
        return bancoId;
    }

    public void setBancoId(Long bancoId) {
        this.bancoId = bancoId;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }


    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public Gestor getGestor() {
        return gestor;
    }

    public void setGestor(Gestor gestor) {
        this.gestor = gestor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Banco banco)) return false;
        return Objects.equals(getBancoId(), banco.getBancoId()) && Objects.equals(getNomeFantasia(), banco.getNomeFantasia()) && Objects.equals(getEndereco(), banco.getEndereco()) && Objects.equals(getEstoque(), banco.getEstoque()) && Objects.equals(getGestor(), banco.getGestor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBancoId(), getNomeFantasia(), getEndereco(), getEstoque(), getGestor());
    }

}
