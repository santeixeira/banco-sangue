package br.ufc.banco;

import br.ufc.banco.domain.Endereco;
import br.ufc.banco.domain.Estoque;
import br.ufc.banco.domain.enumareted.UF;
import br.ufc.banco.service.Banco.BancoDTO;
import br.ufc.banco.service.Banco.BancoService;
import br.ufc.banco.view.DoadorFrame;
import br.ufc.banco.view.UIBancoSangue;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Collections;

@SpringBootApplication
public class BancoApplication {
  public static void main(String[] args) {
    var ctx = new SpringApplicationBuilder(UIBancoSangue.class).headless(false).run(args);
    EventQueue.invokeLater(() -> {
      var ex = ctx.getBean(UIBancoSangue.class);
      ex.setVisible(true);
    });
    SpringApplication app = new SpringApplication(BancoApplication.class);
    app.setDefaultProperties(Collections.singletonMap("server.port", "8083"));
    app.run(args);
  }

  @Bean
  CommandLineRunner run(BancoService bancoService) {
    return args -> {
      bancoService.adicionarBanco(new BancoDTO("Banco A",
                                  new Endereco("R. Barão do Rio Branco", 1816, "Centro", "Fortaleza", UF.CE, "60025-061"),
                                  new Estoque(120, 93, 30, 45)));
      bancoService.adicionarBanco(new BancoDTO("Banco B",
                                  new Endereco("Av. José Bastos", 3390, "Rodolfo Teófilo", "Fortaleza", UF.CE, "60025-061"),
                                  new Estoque(50, 45, 80, 65)));
    };
  }

}
