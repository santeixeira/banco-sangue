package br.ufc.banco.service.Endereco;

import br.ufc.banco.domain.Endereco;
import br.ufc.banco.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    private final EnderecoRepository enderecoRepository;

    public EnderecoServiceImpl(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    @Override
    public List<Endereco> mostrarEnderecos() {
        return null;
    }

    @Override
    public Endereco cadastrarEndereco(EnderecoDTO enderecoDTO) {
        Endereco endereco = new Endereco(null, enderecoDTO.logradouro(), enderecoDTO.numero(),
                enderecoDTO.bairro(), enderecoDTO.cidade(), enderecoDTO.uf(), enderecoDTO.cep());
        return enderecoRepository.save(endereco);
    }

    @Override
    public Endereco atualizarEndereco(EnderecoDTO enderecoDTO) {
        return null;
    }

    @Override
    public void deletarEndereco(EnderecoDTO enderecoDTO) {

    }
}
