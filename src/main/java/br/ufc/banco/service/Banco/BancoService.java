package br.ufc.banco.service.Banco;

import br.ufc.banco.domain.Banco;
import org.springframework.data.domain.Page;

public interface BancoService {

    Page<Banco> visualizarBanco(int page, int size);

    Banco adicionarBanco(BancoDTO bancoDTO);

    Banco editarBanco(BancoDTO bancoDTO);

    void excluirBanco(Long bancoId);
}
