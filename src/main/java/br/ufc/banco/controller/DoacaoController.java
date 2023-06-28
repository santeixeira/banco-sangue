package br.ufc.banco.controller;

import br.ufc.banco.domain.Doacao;
import br.ufc.banco.service.Doacao.DoacaoDTO;
import br.ufc.banco.service.Doacao.DoacaoService;
import br.ufc.banco.service.Estoque.EstoqueService;
import br.ufc.banco.util.Utilitarios;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;

@Controller
@RequestMapping("/api")
public class DoacaoController extends Utilitarios {

    private final DoacaoService doacaoService;
    private final EstoqueService estoqueService;

    public DoacaoController(DoacaoService doacaoService,
                            EstoqueService estoqueService) {
        this.doacaoService = doacaoService;
        this.estoqueService = estoqueService;
    }

    @PostMapping("/doacao/post")
    public ResponseEntity<Doacao> adicionarDoacao(@RequestBody @Valid DoacaoDTO doacaoDTO) {
        URI uri = getUri("/doacao/post");
        Doacao doacao = doacaoService.adicionarDoacao(doacaoDTO);
        return ResponseEntity.created(uri).body(doacao);
    }
}
