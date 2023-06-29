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
  public Banco editarBanco(BancoDTO bancoDTO, Long bancoId) {
    Banco banco = bancoRepository.findById(bancoId).orElseThrow(
        () -> new NoSuchElementException("Banco nao encontrado")
    );
    banco.setNomeFantasia(bancoDTO.nomeFantasia());
    banco.setEndereco(bancoDTO.endereco());
    banco.setEstoque(bancoDTO.estoque());
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
    Banco banco = bancoRepository.findById(solicitacaoDTO.bancoId()).orElseThrow(
        () -> new NoSuchElementException("Banco inválido.")
    );
    Solicitacao solicitacao = new Solicitacao(solicitacaoDTO.quantidade(),
        solicitacaoDTO.tipoSangue(),
        LocalDateTime.now(),
        null,
        Status.Pendente,
        banco);
    solicitacaoRepository.save(solicitacao);
  }

  @Override
  public void enviarSolicitacao(EnvioSolicitacaoDTO envioSolicitacaoDTO) {
    Solicitacao solicitacao = solicitacaoRepository.findById(envioSolicitacaoDTO.bancoReceberId()).orElseThrow(
        () -> new NoSuchElementException("Banco inválido.")
    );
    if (solicitacao.getStatus().equals(Status.Pendente) &&
        !envioSolicitacaoDTO.bancoEnviarId()
            .equals(solicitacao.getBanco().getBancoId())) {
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

  public void enviarBolsaSangue(TipoSangue tipoSangue,
                                Long estoqueReceberId,
                                Long estoqueEnviarId,
                                Integer quantidade) {
    Estoque estoqueReceber = estoqueRepository.findById(estoqueReceberId).orElseThrow();
    Estoque estoqueEnviar = estoqueRepository.findById(estoqueEnviarId).orElseThrow();
    switch (tipoSangue) {
      case A -> {
        estoqueReceber.setQuantidadeA(estoqueReceber.getQuantidadeA() + quantidade);
        estoqueEnviar.setQuantidadeA(estoqueEnviar.getQuantidadeA() - quantidade);
      }

      case B -> {
        estoqueReceber.setQuantidadeB(estoqueReceber.getQuantidadeA() + quantidade);
        estoqueEnviar.setQuantidadeB(estoqueEnviar.getQuantidadeA() - quantidade);
      }
      case O -> {
        estoqueReceber.setQuantidadeO(estoqueReceber.getQuantidadeA() + quantidade);
        estoqueEnviar.setQuantidadeO(estoqueEnviar.getQuantidadeA() - quantidade);
      }
      case AB -> {
        estoqueReceber.setQuantidadeAB(estoqueReceber.getQuantidadeA() + quantidade);
        estoqueEnviar.setQuantidadeAB(estoqueEnviar.getQuantidadeA() - quantidade);
      }
      default -> throw new NoSuchElementException("Tipo sanguíneo inválido.");
    }
  }
}
