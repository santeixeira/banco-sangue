package br.ufc.banco.domain;

import br.ufc.banco.domain.enumareted.Cargos;
import br.ufc.banco.domain.enumareted.TipoSangue;
import br.ufc.banco.domain.enumareted.UF;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@MappedSuperclass
public class Pessoa {
    private String nome;
    private TipoSangue tipoSangue;
    @Column(unique = true)
    private String cpf;
    private String telefone;
    private LocalDateTime dataNascimento;
    private UF naturalidade;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "enderecoId", referencedColumnName = "enderecoId")
    private Endereco endereco;

    public Pessoa() {
    }

    public Pessoa(String nome, TipoSangue tipoSangue, String cpf, String telefone, LocalDateTime dataNascimento, UF naturalidade, Endereco endereco) {
        this.nome = nome;
        this.tipoSangue = tipoSangue;
        this.cpf = cpf;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.naturalidade = naturalidade;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoSangue getTipoSangue() {
        return tipoSangue;
    }

    public void setTipoSangue(TipoSangue tipoSangue) {
        this.tipoSangue = tipoSangue;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDateTime getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDateTime dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public UF getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(UF naturalidade) {
        this.naturalidade = naturalidade;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pessoa pessoa)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getNome(), pessoa.getNome()) && Objects.equals(getCpf(), pessoa.getCpf()) && Objects.equals(getTelefone(), pessoa.getTelefone()) && Objects.equals(getDataNascimento(), pessoa.getDataNascimento()) && getNaturalidade() == pessoa.getNaturalidade() && Objects.equals(getEndereco(), pessoa.getEndereco());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getNome(), getCpf(), getTelefone(), getDataNascimento(), getNaturalidade(), getEndereco());
    }
}
