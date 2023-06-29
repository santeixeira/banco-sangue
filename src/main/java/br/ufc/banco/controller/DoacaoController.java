package br.ufc.banco.controller;

import br.ufc.banco.domain.Doacao;
import br.ufc.banco.service.Doacao.DoacaoDTO;
import br.ufc.banco.service.Doacao.DoacaoService;
import br.ufc.banco.service.Estoque.EstoqueService;
import br.ufc.banco.util.Utilitarios;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@Controller
@RequestMapping("/api")
public class DoacaoController extends Utilitarios {

  private final DoacaoService doacaoService;

  public DoacaoController(DoacaoService doacaoService,
                          EstoqueService estoqueService) {
    this.doacaoService = doacaoService;
  }

  @GetMapping("/doacao")
  public ResponseEntity<Page<Doacao>> listarDoacao(@RequestParam int page,
                                                   @RequestParam int size) {
    Page<Doacao> doacaos = doacaoService.listarDoacao(page, size);
    return ResponseEntity.ok().body(doacaos);
  }

  @PostMapping("/doacao/post")
  public ResponseEntity<Doacao> adicionarDoacao(@RequestBody @Valid DoacaoDTO doacaoDTO) {
    URI uri = getUri("/doacao/post");
    Doacao doacao = doacaoService.adicionarDoacao(doacaoDTO);
    return ResponseEntity.created(uri).body(doacao);
  }

  @GetMapping("/doacao/{doacaoId}")
  public ResponseEntity<Doacao> pesquisarDoacao(@PathVariable Long doacaoId) {
    Doacao doacao = doacaoService.pesquisarDoacao(doacaoId);
    return ResponseEntity.ok().body(doacao);
  }

  @PutMapping("/doacao/editar/{doacaoId}")
  @Transactional
  public ResponseEntity<Doacao> editarDoacao(@PathVariable Long doacaoId,
                                             @RequestBody DoacaoDTO doacaoDTO) {
    Doacao doacao = doacaoService.modificarDoacao(doacaoDTO, doacaoId);
    return ResponseEntity.ok().body(doacao);
  }

  @DeleteMapping("/doacao/deletar/{doacaoId}")
  public ResponseEntity<?> deletarDoacao(@PathVariable Long doacaoId) {
    doacaoService.excluirDoacao(doacaoId);
    return ResponseEntity.ok().build();
  }
}
