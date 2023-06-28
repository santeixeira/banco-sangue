package br.ufc.banco.service.Banco;

import br.ufc.banco.domain.Banco;
import br.ufc.banco.repository.BancoRepository;
import br.ufc.banco.repository.GestorRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class BancoServiceImpl implements BancoService {

    private final BancoRepository bancoRepository;
    private final GestorRepository gestorRepository;

    public BancoServiceImpl(BancoRepository bancoRepository,
                            GestorRepository gestorRepository) {
        this.bancoRepository = bancoRepository;
        this.gestorRepository = gestorRepository;
    }

    @Override
    public Page<Banco> visualizarBanco(int page, int size) {
        return null;
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
    public Banco editarBanco(BancoDTO bancoDTO) {
        return null;
    }

    @Override
    public void excluirBanco(Long bancoId) {
        bancoRepository.deleteById(bancoId);
        System.out.println("Banco deletado com sucesso.");
    }
}
