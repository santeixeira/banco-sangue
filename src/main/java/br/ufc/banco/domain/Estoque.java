package br.ufc.banco.domain;

import br.ufc.banco.domain.enumareted.TipoSangue;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Estoque {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long estoqueId;
  private Integer quantidade;
  private TipoSangue tipoSangue;

  public Estoque() {}

  public Estoque(Long estoqueId, Integer quantidade, TipoSangue tipoSangue) {
    this.estoqueId = estoqueId;
    this.quantidade = quantidade;
    this.tipoSangue = tipoSangue;
  }

  public Long getEstoqueId() {
    return estoqueId;
  }

  public void setEstoqueId(Long estoqueId) {
    this.estoqueId = estoqueId;
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

}
