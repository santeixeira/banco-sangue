package br.ufc.banco.service.Doacao;

import br.ufc.banco.domain.Doacao;
import br.ufc.banco.domain.Doador;
import br.ufc.banco.domain.Estoque;
import br.ufc.banco.domain.enumareted.TipoSangue;
import br.ufc.banco.repository.DoacaoRepository;
import br.ufc.banco.repository.DoadorRepository;
import br.ufc.banco.repository.EstoqueRepository;
import br.ufc.banco.service.Estoque.EstoqueService;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
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
        return null;
    }

    @Override
    public Doacao adicionarDoacao(DoacaoDTO doacaoDTO) {
        Doador doador = doadorRepository
                .findDoadorByCpf(doacaoDTO.cpf()).orElseThrow(
                        () -> new NoSuchElementException("CPF não cadastrado.")
                );
        Doacao doacao = new Doacao(null, doacaoDTO.quantidade(), doador);
        adicionarSangueDoado(doador.getTipoSangue(), doacaoDTO.quantidade());
        return doacaoRepository.save(doacao);
    }

    @Override
    public Doacao modificarDoacao(DoacaoDTO doacaoDTO) {
        return null;
    }

    @Override
    public void excluirDoacao(Long doacaoId) {

    }

    @Override
    public void adicionarParaDoador(String cpf) {

    }

    public void adicionarSangueDoado(TipoSangue tipoSangue, Integer quantidade) {
        Estoque estoque = estoqueRepository.findByTipoSangue(tipoSangue);
        Integer quantidadeAtual = estoque.getQuantidade();
        estoque.setQuantidade(quantidadeAtual + quantidade);
    }


}
