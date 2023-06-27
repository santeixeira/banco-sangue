package br.ufc.banco.service.Endereco;

import br.ufc.banco.domain.Endereco;

import java.util.List;

public interface EnderecoService {
    List<Endereco> mostrarEnderecos();
    Endereco cadastrarEndereco(EnderecoDTO enderecoDTO);
    Endereco atualizarEndereco(EnderecoDTO enderecoDTO);
    void deletarEndereco(EnderecoDTO enderecoDTO);
}
