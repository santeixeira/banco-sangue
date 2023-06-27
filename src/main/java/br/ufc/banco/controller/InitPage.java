package br.ufc.banco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class InitPage {
  @GetMapping("/api")
  @ResponseBody
  public String initial() {
    return "Bem Vindo a api do Banco de Sangue Central do Ceará";
  }
}
