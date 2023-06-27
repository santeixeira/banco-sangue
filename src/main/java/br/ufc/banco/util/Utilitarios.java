package br.ufc.banco.util;

//  Classe abstrata para se utilizar em todos o métodos POST dos Controladores
//  cujo principal intuito é a refatoração do código, evitando assim repetição de código.
//  Além disso, o encapsulamento é importante para o SOLID, e colocar funções de rotinas em
//  classes específicas, como justifica o principio de inversão de dependências.

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

public abstract class Utilitarios {

  // Constroi toda a URI (endereço absoluto)
  // para o servidor com o Endpoint atual já com o
  // Host e a Porta, fornecidas builtin.
  public static URI getUri(String path) {
    return URI.create(ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path(path)
        .toString());
  }
}
