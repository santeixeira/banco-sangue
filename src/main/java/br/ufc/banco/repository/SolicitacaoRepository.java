package br.ufc.banco.repository;

import br.ufc.banco.domain.Banco;
import br.ufc.banco.domain.Solicitacao;
import br.ufc.banco.domain.enumareted.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Long> {

  Solicitacao findByStatusAndBancoId(Status status, Long bancoId);
}
