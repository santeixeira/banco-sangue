package br.ufc.banco.service.Banco;

import br.ufc.banco.domain.Banco;
import br.ufc.banco.domain.Estoque;
import br.ufc.banco.domain.Solicitacao;
import br.ufc.banco.domain.enumareted.Status;
import br.ufc.banco.domain.enumareted.TipoSangue;
import br.ufc.banco.repository.BancoRepository;
import br.ufc.banco.repository.EstoqueRepository;
import br.ufc.banco.repository.SolicitacaoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@Service
public class BancoServiceImpl implements BancoService {

  private final BancoRepository bancoRepository;
  private final SolicitacaoRepository solicitacaoRepository;
  private final EstoqueRepository estoqueRepository;

  public BancoServiceImpl(BancoRepository bancoRepository,
                          SolicitacaoRepository solicitacaoRepository,
                          EstoqueRepository estoqueRepository) {
    this.bancoRepository = bancoRepository;
    this.solicitacaoRepository = solicitacaoRepository;
    this.estoqueRepository = estoqueRepository;
  }

  @Override
  public Page<Banco> visualizarBanco(int page, int size) {
    Pageable pageable = PageRequest.of(page, size);
    return bancoRepository.findAll(pageable);
  }

  @Override
  public Banco adicionarBanco(BancoDTO bancoDTO) {
    Banco banco = new Banco(
        bancoDTO.nomeFantasia(),
        bancoDTO.endereco(),
        bancoDTO.estoque(),
        null
    );
    return bancoRepository.save(banco);
  }

  @Override
  public Banco editarBanco(BancoUpdateDTO bancoUpdateDTO, Long bancoId) {
    Banco banco = encontrarBanco(bancoId);
    banco.setNomeFantasia(bancoUpdateDTO.nomeFantasia());
    banco.setEndereco(bancoUpdateDTO.endereco());
    return bancoRepository.save(banco);
  }

  @Override
  public void excluirBanco(Long bancoId) {
    bancoRepository.deleteById(bancoId);
    System.out.println("Banco deletado com sucesso.");
  }

  @Override
  public Page<Solicitacao> visualizarSolicitacoes(int page, int size) {
    Pageable pageable = PageRequest.of(page, size, Sort.by("dataPedido").descending());
    return solicitacaoRepository.findAll(pageable);
  }

  @Override
  public void abrirSolicitacao(SolicitacaoDTO solicitacaoDTO) {
    Solicitacao solicitacao = new Solicitacao(solicitacaoDTO.quantidade(),
        solicitacaoDTO.tipoSangue(),
        LocalDateTime.now(),
        null,
        Status.Pendente,
        solicitacaoDTO.bancoId());
    solicitacaoRepository.save(solicitacao);
  }

  @Override
  public void enviarSolicitacao(EnvioSolicitacaoDTO envioSolicitacaoDTO) {
    Banco banco = encontrarBanco(envioSolicitacaoDTO.bancoReceberId());
    Solicitacao solicitacao = solicitacaoRepository
        .findByStatusAndBancoId(Status.Pendente, envioSolicitacaoDTO.bancoReceberId());
    if (!envioSolicitacaoDTO.bancoEnviarId().equals(banco.getBancoId())) {
      solicitacao.setStatus(Status.Finalizado);
      solicitacao.setDataRecebido(LocalDateTime.now());
      enviarBolsaSangue(solicitacao.getTipoSangue(),
          envioSolicitacaoDTO.bancoReceberId(),
          envioSolicitacaoDTO.bancoEnviarId(),
          solicitacao.getQuantidade());
      solicitacaoRepository.save(solicitacao);
    } else {
      throw new RuntimeException();
    }
  }

  public Banco encontrarBanco(Long id) {
    return bancoRepository.findById(id).orElseThrow(
        () -> new NoSuchElementException("Banco inválido.")
    );
  }

  public void enviarBolsaSangue(TipoSangue tipoSangue,
                                Long estoqueReceberId,
                                Long estoqueEnviarId,
                                Integer quantidade) {
    Estoque estoqueReceber = estoqueRepository.getReferenceById(estoqueReceberId);
    Estoque estoqueEnviar = estoqueRepository.getReferenceById(estoqueEnviarId);
    switch (tipoSangue) {
      case A -> {
        if (estoqueEnviar.getQuantidadeA() > quantidade * 1.2) {
          estoqueReceber.setQuantidadeA(estoqueReceber.getQuantidadeA() + quantidade);
          estoqueEnviar.setQuantidadeA(estoqueEnviar.getQuantidadeA() - quantidade);
        } else {
          throw new NoSuchElementException("Quantidade insuficiente!");
        }
      }

      case B -> {
        if (estoqueEnviar.getQuantidadeB() > quantidade * 1.2) {
          estoqueReceber.setQuantidadeB(estoqueReceber.getQuantidadeB() + quantidade);
          estoqueEnviar.setQuantidadeB(estoqueEnviar.getQuantidadeB() - quantidade);
        } else {
          throw new NoSuchElementException("Quantidade insuficiente!");
        }
      }
      case O -> {
        if (estoqueEnviar.getQuantidadeO() > quantidade * 1.2) {
          estoqueReceber.setQuantidadeO(estoqueReceber.getQuantidadeO() + quantidade);
          estoqueEnviar.setQuantidadeO(estoqueEnviar.getQuantidadeO() - quantidade);
        } else {
          throw new NoSuchElementException("Quantidade insuficiente!");
        }
      }
      case AB -> {
        if (estoqueEnviar.getQuantidadeAB() > quantidade * 1.2) {
          estoqueReceber.setQuantidadeAB(estoqueReceber.getQuantidadeAB() + quantidade);
          estoqueEnviar.setQuantidadeAB(estoqueEnviar.getQuantidadeAB() - quantidade);
        } else {
          throw new NoSuchElementException("Quantidade insuficiente!");
        }
      }
      default -> throw new NoSuchElementException("Tipo sanguíneo inválido.");
    }
  }
}
