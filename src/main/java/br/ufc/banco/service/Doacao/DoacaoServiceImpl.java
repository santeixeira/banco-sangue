package br.ufc.banco.service.Doacao;

import br.ufc.banco.domain.Banco;
import br.ufc.banco.domain.Doacao;
import br.ufc.banco.domain.Doador;
import br.ufc.banco.domain.Estoque;
import br.ufc.banco.domain.enumareted.TipoSangue;
import br.ufc.banco.repository.BancoRepository;
import br.ufc.banco.repository.DoacaoRepository;
import br.ufc.banco.repository.DoadorRepository;
import br.ufc.banco.repository.EstoqueRepository;
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
    private final BancoRepository bancoRepository;

    public DoacaoServiceImpl(DoadorRepository doadorRepository, DoacaoRepository doacaoRepository, EstoqueRepository estoqueRepository, BancoRepository bancoRepository) {
        this.doadorRepository = doadorRepository;
        this.doacaoRepository = doacaoRepository;
        this.estoqueRepository = estoqueRepository;
        this.bancoRepository = bancoRepository;
    }

    @Override
    public Page<Doacao> listarDoacao(int page, int size) {
        return null;
    }

    @Override
    public Doacao adicionarDoacao(DoacaoDTO doacaoDTO) {
        Doador doador = doadorRepository.findDoadorByCpf(doacaoDTO.cpf()).orElseThrow(() -> new NoSuchElementException("CPF não cadastrado."));
        Doacao doacao = new Doacao(null, doacaoDTO.quantidade(), doador);
        adicionarSangueDoado(doador.getTipoSangue(), doacaoDTO.bancoId(), doacaoDTO.quantidade());
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
