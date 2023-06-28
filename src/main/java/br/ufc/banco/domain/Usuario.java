package br.ufc.banco.domain;

import br.ufc.banco.domain.enumareted.Cargos;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Usuario {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long usuarioId;
  private String email;
  private String senha;
  private LocalDateTime criacao;
  private LocalDateTime ultimoAcesso;
  @JsonManagedReference
  private Cargos cargos;

  public Usuario () {}

  public Usuario(Long usuarioId, String email, String senha, LocalDateTime criacao, LocalDateTime ultimoAcesso, Cargos cargos) {
    this.usuarioId = usuarioId;
    this.email = email;
    this.senha = senha;
    this.criacao = criacao;
    this.ultimoAcesso = ultimoAcesso;
    this.cargos = cargos;
  }

  public Long getUserId() {
    return usuarioId;
  }

  public void setUserId(Long usuarioId) {
    this.usuarioId = usuarioId;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public LocalDateTime getCriacao() {
    return criacao;
  }

  public void setCriacao(LocalDateTime criacao) {
    this.criacao = criacao;
  }

  public LocalDateTime getUltimoAcesso() {
    return ultimoAcesso;
  }

  public void setUltimoAcesso(LocalDateTime ultimoAcesso) {
    this.ultimoAcesso = ultimoAcesso;
  }

  public Cargos getCargos() {
    return cargos;
  }

  public void setCargos(Cargos cargos) {
    this.cargos = cargos;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Usuario usuario)) return false;
    return Objects.equals(usuarioId, usuario.usuarioId) && Objects.equals(email, usuario.email) && Objects.equals(senha, usuario.senha) && Objects.equals(criacao, usuario.criacao) && Objects.equals(ultimoAcesso, usuario.ultimoAcesso) && cargos == usuario.cargos;
  }

  @Override
  public int hashCode() {
    return Objects.hash(usuarioId, email, senha, criacao, ultimoAcesso, cargos);
  }
}
