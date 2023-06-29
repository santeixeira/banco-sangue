package br.ufc.banco.service.Doacao;

import br.ufc.banco.domain.Doacao;
import org.springframework.data.domain.Page;

public interface DoacaoService {
  Page<Doacao> listarDoacao(int page, int size);

  Doacao adicionarDoacao(DoacaoDTO doacaoDTO);

  Doacao modificarDoacao(DoacaoDTO doacaoDTO, Long doacaoId);

  Doacao pesquisarDoacao(Long doacaoId);

  void excluirDoacao(Long doacaoId);

}
