package br.ufc.banco.repository;

import br.ufc.banco.domain.Doacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoacaoRepository extends JpaRepository<Doacao, Long> {
}
