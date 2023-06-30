package br.ufc.banco.domain;

import br.ufc.banco.domain.enumareted.UF;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Endereco {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long enderecoId;
  private String logradouro;
  private Integer numero;
  private String bairro;
  private String cidade;
  private UF uf;
  private String cep;

  public Endereco() {
  }

  public Endereco(String logradouro, Integer numero, String bairro, String cidade, UF uf, String cep) {
    this.logradouro = logradouro;
    this.numero = numero;
    this.bairro = bairro;
    this.cidade = cidade;
    this.uf = uf;
    this.cep = cep;
  }

  public Long getEnderecoId() {
    return enderecoId;
  }

  public void setEnderecoId(Long enderecoId) {
    this.enderecoId = enderecoId;
  }

  public String getLogradouro() {
    return logradouro;
  }

  public void setLogradouro(String logradouro) {
    this.logradouro = logradouro;
  }

  public Integer getNumero() {
    return numero;
  }

  public void setNumero(Integer numero) {
    this.numero = numero;
  }

  public String getBairro() {
    return bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public UF getUf() {
    return uf;
  }

  public void setUf(UF uf) {
    this.uf = uf;
  }

  public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }
}
