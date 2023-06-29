package br.ufc.banco.domain;

import br.ufc.banco.domain.enumareted.Status;
import br.ufc.banco.domain.enumareted.TipoSangue;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Solicitacao {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long solicitacaoId;
  private Integer quantidade;
  private TipoSangue tipoSangue;
  private LocalDateTime dataPedido;
  private LocalDateTime dataRecebido;
  private Status status;
  private Long bancoId;


  public Solicitacao() {
  }

  public Solicitacao(Integer quantidade, TipoSangue tipoSangue, LocalDateTime dataPedido, LocalDateTime dataRecebido, Status status, Long bancoId) {
    this.quantidade = quantidade;
    this.tipoSangue = tipoSangue;
    this.dataPedido = dataPedido;
    this.dataRecebido = dataRecebido;
    this.status = status;
    this.bancoId = bancoId;
  }

  public Long getSolicitacaoId() {
    return solicitacaoId;
  }

  public void setSolicitacaoId(Long solicitacaoId) {
    this.solicitacaoId = solicitacaoId;
  }

  public Integer getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(Integer quantidade) {
    this.quantidade = quantidade;
  }

  public TipoSangue getTipoSangue() {
    return tipoSangue;
  }

  public void setTipoSangue(TipoSangue tipoSangue) {
    this.tipoSangue = tipoSangue;
  }

  public LocalDateTime getDataPedido() {
    return dataPedido;
  }

  public void setDataPedido(LocalDateTime dataPedido) {
    this.dataPedido = dataPedido;
  }

  public LocalDateTime getDataRecebido() {
    return dataRecebido;
  }

  public void setDataRecebido(LocalDateTime dataRecebido) {
    this.dataRecebido = dataRecebido;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public Long getBancoId() {
    return bancoId;
  }

  public void setBancoId(Long banco) {
    this.bancoId = banco;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Solicitacao that)) return false;
    return Objects.equals(getSolicitacaoId(), that.getSolicitacaoId()) && Objects.equals(getQuantidade(), that.getQuantidade()) && getTipoSangue() == that.getTipoSangue() && Objects.equals(getDataPedido(), that.getDataPedido()) && Objects.equals(getDataRecebido(), that.getDataRecebido()) && getStatus() == that.getStatus() && Objects.equals(getBancoId(), that.getBancoId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getSolicitacaoId(), getQuantidade(), getTipoSangue(), getDataPedido(), getDataRecebido(), getStatus(), getBancoId());
  }
}
