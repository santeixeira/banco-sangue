package br.ufc.banco.repository;

import br.ufc.banco.domain.Solicitacao;
import br.ufc.banco.domain.enumareted.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Long> {
  Solicitacao findByStatus(Status status);
}
