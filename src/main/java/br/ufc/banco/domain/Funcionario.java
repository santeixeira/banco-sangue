package br.ufc.banco.domain;

import br.ufc.banco.domain.enumareted.Cargos;
import br.ufc.banco.domain.enumareted.TipoSangue;
import br.ufc.banco.domain.enumareted.UF;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Funcionario extends Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long funcionarioId;
    private BigDecimal salario;
    private String setor;
    private LocalDateTime dataAdmissao;
    @OneToOne
    @JoinColumn(name = "usuarioId", referencedColumnName = "usuarioId")
    private Usuario usuario;

    public Funcionario() {
    }

    public Funcionario(String nome, TipoSangue tipoSangue, String cpf, String telefone, LocalDateTime dataNascimento, UF naturalidade, Endereco endereco, Long funcionarioId, BigDecimal salario, String setor, LocalDateTime dataAdmissao, Usuario usuario) {
        super(nome, tipoSangue, cpf, telefone, dataNascimento, naturalidade, endereco);
        this.funcionarioId = funcionarioId;
        this.salario = salario;
        this.setor = setor;
        this.dataAdmissao = dataAdmissao;
        this.usuario = usuario;
    }

    public Long getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(Long funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public LocalDateTime getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDateTime dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Funcionario that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getFuncionarioId(), that.getFuncionarioId()) && Objects.equals(getSalario(), that.getSalario()) && Objects.equals(getSetor(), that.getSetor()) && Objects.equals(getDataAdmissao(), that.getDataAdmissao()) && Objects.equals(getUsuario(), that.getUsuario());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getFuncionarioId(), getSalario(), getSetor(), getDataAdmissao(), getUsuario());
    }
}
