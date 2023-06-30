package br.ufc.banco.util;

//  Classe abstrata para se utilizar em todos o métodos POST dos Controladores
//  cujo principal intuito é a refatoração do código, evitando assim repetição de código.
//  Além disso, o encapsulamento é importante para o SOLID, e colocar funções de rotinas em
//  classes específicas, como justifica o principio de inversão de dependências.

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;

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

  // Requisições HTTP para o Swing

  public static void responseHttpPost(String endpoint, String message) {
    try {
        var client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8083/api/" + endpoint))
                .header("Content-Type", "application/json")
                .POST(BodyPublishers.ofString(message))
                .build();
        client.send(httpRequest, BodyHandlers.discarding());

      } catch (IOException | InterruptedException e) {
        throw new RuntimeException(e);
      }
  }
}
