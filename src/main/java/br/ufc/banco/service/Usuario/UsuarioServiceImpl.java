package br.ufc.banco.service.Usuario;

import br.ufc.banco.domain.Usuario;
import br.ufc.banco.repository.UsuarioRepository;
import br.ufc.banco.service.PessoaDTO;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

    // Mais uma parte que poderia ser evitada o Boilerplate com anotações,
    // mas, para fins didaticos da disciplina, se adiciona um construtor.
    // @Autowired ou @RequiredAllArgs na classe

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Page<Usuario> mostrarUsuarios(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return usuarioRepository.findAll(pageable);
    }

    @Override
    public Usuario adicionarPessoaParaUsuario(PessoaDTO pessoaDTO) {
        return null;
    }

    @Override
    public Usuario cadastrar(UsuarioDTO usuarioDTO) {
        String senha = usuarioDTO.senha();
        LocalDateTime dataAtual = LocalDateTime.now();
        Usuario usuario = new Usuario(
                null,
                usuarioDTO.email(),
                senha,
                dataAtual,
                dataAtual,
                usuarioDTO.cargos()
        );
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario login(UsuarioDTO usuarioDTO) {
        return null;
    }
}
