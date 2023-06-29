package br.ufc.banco.service.Banco;

import br.ufc.banco.domain.Banco;
import br.ufc.banco.domain.Solicitacao;
import org.springframework.data.domain.Page;

public interface BancoService {

    Page<Banco> visualizarBanco(int page, int size);

    Banco adicionarBanco(BancoDTO bancoDTO);

    Banco editarBanco(BancoDTO bancoDTO, Long bancoId);

    void excluirBanco(Long bancoId);

    Page<Solicitacao> visualizarSolicitacoes(int page, int size);

    void abrirSolicitacao(SolicitacaoDTO solicitacaoDTO);

    void enviarSolicitacao(EnvioSolicitacaoDTO envioSolicitacaoDTO);
}
