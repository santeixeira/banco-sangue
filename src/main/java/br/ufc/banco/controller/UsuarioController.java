package br.ufc.banco.controller;

import br.ufc.banco.domain.Usuario;
import br.ufc.banco.service.PessoaDTO;
import br.ufc.banco.service.Usuario.UsuarioDTO;
import br.ufc.banco.service.Usuario.UsuarioService;
import br.ufc.banco.util.Utilitarios;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api")
public class UsuarioController extends Utilitarios {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/usuarios")
    public ResponseEntity<Page<Usuario>> visualizarUsuarios(@RequestParam int page, @RequestParam int size) {
        return ResponseEntity.ok().body(usuarioService.mostrarUsuarios(page, size));
    }

    @PostMapping(value = "/usuarios/post")
    public ResponseEntity<Usuario> cadastraUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO) {
        URI uri = getUri("/cadastro");
        Usuario usuario = usuarioService.cadastrar(usuarioDTO);
        return ResponseEntity.created(uri).body(usuario);
    }

    @PostMapping(value = "/pessoas/adicionar")
    public ResponseEntity<Usuario> adicionarPessoa(@RequestBody @Valid PessoaDTO pessoaDTO) {
        URI uri = getUri("/pessoas/adicionar");
        Usuario usuario = usuarioService.adicionarPessoaParaUsuario(pessoaDTO);
        return ResponseEntity.created(uri).body(usuario);
    }
}
