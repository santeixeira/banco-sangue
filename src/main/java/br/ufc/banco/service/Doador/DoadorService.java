package br.ufc.banco.service.Doador;

import br.ufc.banco.domain.Doador;
import br.ufc.banco.service.PessoaDTO;
import org.springframework.data.domain.Page;

public interface DoadorService {
    Page<Doador> listarDoadores(int page, int size);
    Doador adicionarDoador(PessoaDTO pessoaDTO);
    Doador editarDoador(PessoaDTO pessoaDTO);
    void anonimizarDoador(String cpf);

}
