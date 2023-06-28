package br.ufc.banco.repository;

import br.ufc.banco.domain.Estoque;
import br.ufc.banco.domain.enumareted.TipoSangue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
}
