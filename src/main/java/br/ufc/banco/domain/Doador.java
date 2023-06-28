package br.ufc.banco.domain;

import br.ufc.banco.domain.enumareted.TipoSangue;
import br.ufc.banco.domain.enumareted.UF;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Doador extends Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doadorId;
    private LocalDateTime ultimaDoacao;

    private Doador() {
    }

    public Doador(String nome, TipoSangue tipoSangue, String cpf, String telefone, LocalDateTime dataNascimento, UF naturalidade, Endereco endereco, LocalDateTime ultimaDoacao) {
        super(nome, tipoSangue, cpf, telefone, dataNascimento, naturalidade, endereco);
        this.ultimaDoacao = ultimaDoacao;
    }

    public Long getDoadorId() {
        return doadorId;
    }

    public void setDoadorId(Long doadorId) {
        this.doadorId = doadorId;
    }

    public LocalDateTime getUltimaDoacao() {
        return ultimaDoacao;
    }

    public void setUltimaDoacao(LocalDateTime ultimaDoacao) {
        this.ultimaDoacao = ultimaDoacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Doador doador)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getDoadorId(), doador.getDoadorId()) && Objects.equals(getUltimaDoacao(), doador.getUltimaDoacao());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getDoadorId(), getUltimaDoacao());
    }
}
