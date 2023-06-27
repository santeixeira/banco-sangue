package br.ufc.banco.controller;

import br.ufc.banco.domain.Doador;
import br.ufc.banco.service.Doador.DoadorService;
import br.ufc.banco.service.PessoaDTO;
import br.ufc.banco.util.Utilitarios;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api")
public class DoadorController extends Utilitarios {

    private final DoadorService doadorService;

    public DoadorController (DoadorService doadorService) {  this.doadorService = doadorService; }

    @GetMapping("/doadores")
    public ResponseEntity<Page<Doador>> mostrarTodos(@RequestParam int page, @RequestParam int size) {
        return ResponseEntity.ok().body(doadorService.listarDoadores(page, size));
    }

    @PostMapping("/doadores/post")
    public ResponseEntity<Doador> adicionarDoador(@RequestBody PessoaDTO pessoaDTO) {
        URI uri = getUri("/doadores/post");
        Doador doador = doadorService.adicionarDoador(pessoaDTO);
        return ResponseEntity.created(uri).body(doador);
    }

}
