package br.ufc.banco.repository;

import br.ufc.banco.domain.Banco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BancoRepository extends JpaRepository<Banco, Long> {
    Banco findByNomeFantasia(String nomeFantasia);
}
