package br.ufc.banco.repository;

import br.ufc.banco.domain.Doador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoadorRepository extends JpaRepository<Doador, Long> {
    Optional<Doador> findDoadorByCpf(String cpf);
}
