package br.ufc.banco.service.Doacao;

import br.ufc.banco.domain.Doacao;
import br.ufc.banco.domain.Doador;
import br.ufc.banco.domain.Estoque;
import br.ufc.banco.domain.enumareted.TipoSangue;
import br.ufc.banco.repository.DoacaoRepository;
import br.ufc.banco.repository.DoadorRepository;
import br.ufc.banco.repository.EstoqueRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@Transactional
public class DoacaoServiceImpl implements DoacaoService {

  private final DoadorRepository doadorRepository;
  private final DoacaoRepository doacaoRepository;
  private final EstoqueRepository estoqueRepository;

  public DoacaoServiceImpl(DoadorRepository doadorRepository, DoacaoRepository doacaoRepository, EstoqueRepository estoqueRepository) {
    this.doadorRepository = doadorRepository;
    this.doacaoRepository = doacaoRepository;
    this.estoqueRepository = estoqueRepository;
  }

  @Override
  public Page<Doacao> listarDoacao(int page, int size) {
    Pageable pageable = PageRequest.of(page, size);
    return doacaoRepository.findAll(pageable);
  }

  @Override
  public Doacao adicionarDoacao(DoacaoDTO doacaoDTO) {
    Doador doador = pesquisarDoador(doacaoDTO.cpf());
    Doacao doacao = new Doacao(doacaoDTO.quantidade(), doador);
    adicionarSangueDoado(doador.getTipoSangue(), doacaoDTO.bancoId(), doacaoDTO.quantidade());
    return doacaoRepository.save(doacao);
  }

  @Override
  public Doacao modificarDoacao(DoacaoDTO doacaoDTO, Long doacaoId) {
    Doacao doacao = pesquisarDoacao(doacaoId);
    Doador doador = pesquisarDoador(doacaoDTO.cpf());
    Integer quantMod = doacao.getQuantidade() - doacaoDTO.quantidade();
    doacao.setQuantidade(doacaoDTO.quantidade());
    doacao.setDoador(doador);
    adicionarSangueDoado(doador.getTipoSangue(), doacaoDTO.bancoId(), quantMod);
    return doacaoRepository.save(doacao);
  }

  @Override
  public Doacao pesquisarDoacao(Long doacaoId) {
    return doacaoRepository.findById(doacaoId).orElseThrow(
        () -> new NoSuchElementException("Doação inválida.")
    );
  }

  @Override
  public void excluirDoacao(Long doacaoId) {
    doacaoRepository.delete(pesquisarDoacao(doacaoId));
  }

  public Doador pesquisarDoador(String cpf) {
    return doadorRepository.findDoadorByCpf(cpf).orElseThrow(
        () -> new NoSuchElementException("CPF não cadastrado."));
  }

  public void adicionarSangueDoado(TipoSangue tipoSangue, Long estoqueId, Integer quantidade) {
    Estoque estoque = estoqueRepository.findById(estoqueId).orElseThrow();
    switch (tipoSangue) {
      case A -> estoque.setQuantidadeA(estoque.getQuantidadeA() + quantidade);
      case B -> estoque.setQuantidadeB(estoque.getQuantidadeB() + quantidade);
      case O -> estoque.setQuantidadeO(estoque.getQuantidadeO() + quantidade);
      case AB -> estoque.setQuantidadeAB(estoque.getQuantidadeAB() + quantidade);
      default -> throw new NoSuchElementException("Tipo sanguíneo inválido.");
    }
  }


}
