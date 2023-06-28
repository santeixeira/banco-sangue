package br.ufc.banco.controller;

import br.ufc.banco.domain.Funcionario;
import br.ufc.banco.service.Funcionario.FuncionarioDTO;
import br.ufc.banco.service.Funcionario.FuncionarioService;
import br.ufc.banco.service.Funcionario.GestorDTO;
import br.ufc.banco.service.PessoaDTO;
import br.ufc.banco.util.Utilitarios;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@Controller
@RequestMapping("/api")
public class FuncionarioController extends Utilitarios {

    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping("/funcionarios")
    public ResponseEntity<Page<Funcionario>> mostrarFuncionarios(@RequestParam int page,
                                                                 @RequestParam int size) {
        Page<Funcionario> data = funcionarioService.listarFuncionarios(page, size);
        return ResponseEntity.ok().body(data);
    }

    @PostMapping("/funcionarios/post")
    public ResponseEntity<Funcionario> adicionarFuncionario(@RequestBody @Valid FuncionarioDTO funcionarioDTO) {
        URI uri = getUri("/funcionarios/post");
        Funcionario funcionario = funcionarioService.adicionarFuncionario(funcionarioDTO);
        return ResponseEntity.created(uri).body(funcionario);
    }

    @PostMapping("/funcionarios/atribuirGestor")
    public ResponseEntity<?> atribuirGestor(@RequestBody @Valid GestorDTO gestorDTO) {
        funcionarioService.atribuirGestor(gestorDTO);
        return ResponseEntity.ok().build();
    }
}
