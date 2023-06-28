package br.ufc.banco.service.Estoque;

import br.ufc.banco.domain.Estoque;
import br.ufc.banco.domain.enumareted.TipoSangue;
import br.ufc.banco.repository.EstoqueRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class EstoqueServiceImpl implements EstoqueService {

    private final EstoqueRepository estoqueRepository;
    public EstoqueServiceImpl(EstoqueRepository estoqueRepository) {
        this.estoqueRepository = estoqueRepository;
    }
    @Override
    public List<Estoque> mostrarEstoque() {
        return estoqueRepository.findAll();
    }
}
