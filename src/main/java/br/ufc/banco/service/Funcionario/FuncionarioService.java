package br.ufc.banco.service.Funcionario;

import br.ufc.banco.domain.Funcionario;
import br.ufc.banco.domain.Gestor;
import br.ufc.banco.service.PessoaDTO;
import org.springframework.data.domain.Page;

public interface FuncionarioService {
    Page<Funcionario> listarFuncionarios(int page, int size);

    Funcionario adicionarFuncionario(FuncionarioDTO funcionarioDTO);

    Funcionario editarFuncionario(FuncionarioDTO funcionarioDTO);

    void excluirFuncionario(Long funcionarioId);

    void atribuirGestor(GestorDTO gestorDTO);

}
