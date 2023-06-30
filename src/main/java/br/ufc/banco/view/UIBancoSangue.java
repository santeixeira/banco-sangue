package br.ufc.banco.view;

import br.ufc.banco.service.Doador.DoadorService;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;
import java.awt.event.ActionEvent;

@SpringBootApplication
public class UIBancoSangue extends JFrame {

  public UIBancoSangue() {
    initUI();

  }

  private void initUI() {
    DoadorFrame doadorFrame = new DoadorFrame();
    doadorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    var quitButton = new JButton("Adicionar Doador");
    quitButton.addActionListener((ActionEvent e) -> {
      doadorFrame.setVisible(true);
      setVisible(false);
    });

    createLayout(quitButton);

    setTitle("Quit button");
    setSize(300, 200);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  private void createLayout(JComponent... arg) {
    var pane = getContentPane();
    var gl = new GroupLayout(pane);
    pane.setLayout(gl);

    gl.setAutoCreateContainerGaps(true);
    gl.setHorizontalGroup(gl.createSequentialGroup().addComponent(arg[0]));
    gl.setVerticalGroup(gl.createSequentialGroup().addComponent(arg[0]));
  }
}
