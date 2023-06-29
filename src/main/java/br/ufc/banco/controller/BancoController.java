package br.ufc.banco.controller;

import br.ufc.banco.domain.Banco;
import br.ufc.banco.domain.Solicitacao;
import br.ufc.banco.service.Banco.BancoDTO;
import br.ufc.banco.service.Banco.BancoService;
import br.ufc.banco.service.Banco.EnvioSolicitacaoDTO;
import br.ufc.banco.service.Banco.SolicitacaoDTO;
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
public class BancoController extends Utilitarios {
  private final BancoService bancoService;

  public BancoController(BancoService bancoService) {
    this.bancoService = bancoService;
  }

  @GetMapping("/banco")
  public ResponseEntity<Page<Banco>> listarBancos(@RequestParam int page, @RequestParam int size) {
    Page<Banco> data = bancoService.visualizarBanco(page, size);
    return ResponseEntity.ok().body(data);
  }

  @PostMapping("/banco/post")
  public ResponseEntity<Banco> adicionarBanco(@RequestBody @Valid BancoDTO bancoDTO) {
    URI uri = getUri("/banco/post");
    Banco banco = bancoService.adicionarBanco(bancoDTO);
    return ResponseEntity.created(uri).body(banco);
  }

  @PutMapping("/banco/editar/{bancoId}")
  @Transactional
  public ResponseEntity<Banco> editarBanco(@RequestBody @Valid BancoDTO bancoDTO,
                                           @PathVariable Long bancoId) {
    Banco data = bancoService.editarBanco(bancoDTO, bancoId);
    return ResponseEntity.ok().body(data);
  }

  @DeleteMapping("/banco/delete/{bancoId}")
  public ResponseEntity<?> excluirBanco(@PathVariable Long bancoId) {
    bancoService.excluirBanco(bancoId);
    return ResponseEntity.ok().build();
  }

  @GetMapping("/banco/solicitacao")
  public ResponseEntity<Page<Solicitacao>> listarSolicitacoes(@RequestParam int page,
                                                              @RequestParam int size) {
    Page<Solicitacao> data = bancoService.visualizarSolicitacoes(page, size);
    return ResponseEntity.ok().body(data);
  }

  @PostMapping("/banco/solicitacao/abertura")
  public ResponseEntity<?> abrirSolicitacao(@RequestBody @Valid SolicitacaoDTO solicitacaoDTO) {
    bancoService.abrirSolicitacao(solicitacaoDTO);
    return ResponseEntity.ok().build();
  }

  @PostMapping("/banco/solicitacao/enviar")
  public ResponseEntity<?> enviarSolicitacao(@RequestBody EnvioSolicitacaoDTO envioSolicitacaoDTO) {
    bancoService.enviarSolicitacao(envioSolicitacaoDTO);
    return ResponseEntity.ok().build();
  }


}


