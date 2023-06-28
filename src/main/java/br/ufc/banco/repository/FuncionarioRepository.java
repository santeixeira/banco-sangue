package br.ufc.banco.repository;

import br.ufc.banco.domain.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    /* Neste caso, poderia ser feito por alguma matrícula
       Para deixar os dados do funcionário anônimo, mas para
       ser mais direto e não fugir muito do escopo do trabalho:
     */
    Funcionario findFuncionarioByCpf(String cpf);
}
