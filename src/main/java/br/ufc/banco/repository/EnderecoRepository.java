package br.ufc.banco.repository;

import br.ufc.banco.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    List<Endereco> findEnderecoByCep(String cep);
}
