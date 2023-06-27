package br.ufc.banco.service.Usuario;

import br.ufc.banco.domain.Usuario;
import br.ufc.banco.service.PessoaDTO;
import org.springframework.data.domain.Page;

// Classe contrato para ser injetado no controlador
// Seguindo a arquitetura bridge, onde os métodos abstratos
// da interface Service deve ser implementados para serem
// usados na classe controlador.

public interface UsuarioService {
    Page<Usuario> mostrarUsuarios(int page, int size);

    Usuario adicionarPessoaParaUsuario(PessoaDTO pessoaDTO);

    Usuario cadastrar(UsuarioDTO usuarioDTO);

    Usuario login(UsuarioDTO usuarioDTO);
}
