package br.ufc.banco.controller;

import br.ufc.banco.domain.Endereco;
import br.ufc.banco.service.Endereco.EnderecoDTO;
import br.ufc.banco.service.Endereco.EnderecoService;
import br.ufc.banco.util.Utilitarios;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/api")
public class EnderecoController extends Utilitarios {
    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping("/enderecos")
    public ResponseEntity<List<Endereco>> visualizarEnderecos() {
        List<Endereco> data = enderecoService.mostrarEnderecos();
        return ResponseEntity.ok().body(data);
    }

    @PostMapping(value = "/endereco/post")
    public ResponseEntity<Endereco> criarEndereco(@RequestBody @Valid EnderecoDTO enderecoDTO) {
        URI uri = getUri("/endereco/post");
        Endereco endereco = enderecoService.cadastrarEndereco(enderecoDTO);
        return ResponseEntity.created(uri).body(endereco);
    }
}
