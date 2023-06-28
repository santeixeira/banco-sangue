package br.ufc.banco.repository;

import br.ufc.banco.domain.Gestor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GestorRepository extends JpaRepository<Gestor, Long> {
}
