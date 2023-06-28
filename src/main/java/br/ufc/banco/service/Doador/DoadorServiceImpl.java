package br.ufc.banco.service.Doador;

import br.ufc.banco.domain.Doador;
import br.ufc.banco.repository.DoadorRepository;
import br.ufc.banco.service.PessoaDTO;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Transactional
public class DoadorServiceImpl implements DoadorService {

    private final DoadorRepository doadorRepository;

    public DoadorServiceImpl(DoadorRepository doadorRepository) {
        this.doadorRepository = doadorRepository;
    }

    @Override
    public Page<Doador> listarDoadores(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return doadorRepository.findAll(pageable);
    }

    @Override
    public Doador adicionarDoador(PessoaDTO pessoaDTO) {
        Doador doador = new Doador(
                pessoaDTO.nome(),
                pessoaDTO.tipoSangue(),
                pessoaDTO.cpf(),
                pessoaDTO.telefone(),
                pessoaDTO.dataNascimento(),
                pessoaDTO.naturalidade(),
                pessoaDTO.endereco(),
                LocalDateTime.now()
        );
        return doadorRepository.save(doador);
    }

    @Override
    public Doador editarDoador(PessoaDTO pessoaDTO) {
        return null;
    }

    @Override
    public void anonimizarDoador(String cpf) {

    }
}
