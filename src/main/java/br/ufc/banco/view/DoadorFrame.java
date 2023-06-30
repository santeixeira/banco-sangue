package br.ufc.banco.view;

import br.ufc.banco.domain.enumareted.TipoSangue;
import br.ufc.banco.domain.enumareted.UF;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;

public class DoadorFrame extends JFrame {
  private static final long serialVersionUIDLONG = 1L;
  private JLabel lbTipoSangue, lbNome, lbCpf, lbTelefone, lbDataNascimento, lbNaturalidade, lbLogradouro, lbNumero, lbBairro, lbCidade, lbEstado, lbCEP;
  private JTextField txtNome, txtCpf, txtTelefone, txtDataNascimento, txtLogradouro, txtNumero, txtBairro, txtCidade, txtCep;
  private JComboBox<TipoSangue> cbTipoSangue;
  private JComboBox<UF> cbNaturalidade, cbEstado;
  private JButton botaoSalvar, botaoEditar, botaoLimpar, botaoApagar;
  private JTable tabela;
  private DefaultTableModel modelo;

  public DoadorFrame() {
    super("Doador");
    Container container = getContentPane();
    setLayout(null);

    lbNome = new JLabel("Nome");
    txtNome = new JTextField();

    lbCpf = new JLabel("CPF");
    txtCpf = new JTextField();

    lbTipoSangue = new JLabel("Tipo Sanguíneo");
    cbTipoSangue = new JComboBox<TipoSangue>();

    lbTelefone = new JLabel("Telefone");
    txtTelefone = new JTextField();

    lbDataNascimento = new JLabel("Data de Nascimento");
    txtDataNascimento = new JTextField();

    lbNaturalidade = new JLabel("Naturalidade");
    cbNaturalidade = new JComboBox<UF>();

    lbLogradouro = new JLabel("Logradouro");
    txtLogradouro = new JTextField();

    lbNumero = new JLabel("Número");
    txtNumero = new JTextField();

    lbBairro = new JLabel("Bairro");
    txtBairro = new JTextField();

    lbCidade = new JLabel("Cidade");
    txtCidade = new JTextField();

    lbEstado = new JLabel("Estado");
    cbEstado = new JComboBox<UF>();

    lbCEP = new JLabel("CEP");
    txtCep = new JTextField();

    lbNome.setBounds(10, 10, 240, 15);
    txtNome.setBounds(10, 25, 240, 25);
    container.add(lbNome);
    container.add(txtNome);

    lbCpf.setBounds(260, 10, 240, 15);
    txtCpf.setBounds(260, 25, 240, 25);
    container.add(lbCpf);
    container.add(txtCpf);

    lbTipoSangue.setBounds(510, 10, 120, 15);
    cbTipoSangue.setBounds(510, 25, 120, 25);
    cbTipoSangue.setModel(new DefaultComboBoxModel<>(TipoSangue.values()));
    container.add(lbTipoSangue);
    container.add(cbTipoSangue);
    ;

    lbTelefone.setBounds(640, 10, 240, 15);
    txtTelefone.setBounds(640, 25, 240, 25);
    container.add(lbTelefone);
    container.add(txtTelefone);

    lbNaturalidade.setBounds(10, 60, 240, 15);
    cbNaturalidade.setBounds(10, 75, 240, 25);
    cbNaturalidade.setModel(new DefaultComboBoxModel<>(UF.values()));
    container.add(lbNaturalidade);
    container.add(cbNaturalidade);

    lbDataNascimento.setBounds(260, 60, 240, 15);
    txtDataNascimento.setBounds(260, 75, 240, 25);
    container.add(lbDataNascimento);
    container.add(txtDataNascimento);

    lbCEP.setBounds(10, 110, 240, 15);
    txtCep.setBounds(10, 125, 240, 25);
    container.add(lbCEP);
    container.add(txtCep);

    lbLogradouro.setBounds(260, 110, 240, 15);
    txtLogradouro.setBounds(260, 125, 240, 25);
    container.add(lbLogradouro);
    container.add(txtLogradouro);

    lbNumero.setBounds(510, 110, 240, 15);
    txtNumero.setBounds(510, 125, 240, 25);
    container.add(lbNumero);
    container.add(txtNumero);

    lbEstado.setBounds(760, 110, 120, 15);
    cbEstado.setBounds(760, 125, 120, 25);
    cbEstado.setModel(new DefaultComboBoxModel<>(UF.values()));
    container.add(lbEstado);
    container.add(cbEstado);

    lbCidade.setBounds(10, 160, 240, 15);
    txtCidade.setBounds(10, 175, 240, 25);
    container.add(lbCidade);
    container.add(txtCidade);

    lbBairro.setBounds(260, 160, 240, 15);
    txtBairro.setBounds(260, 175, 240, 25);
    container.add(lbBairro);
    container.add(txtBairro);

    lbNome.setForeground(Color.BLACK);
    lbCpf.setForeground(Color.BLACK);
    lbTelefone.setForeground(Color.BLACK);
    lbDataNascimento.setForeground(Color.BLACK);
    lbNaturalidade.setForeground(Color.BLACK);
    lbLogradouro.setForeground(Color.BLACK);
    lbNumero.setForeground(Color.BLACK);
    lbBairro.setForeground(Color.BLACK);
    lbCidade.setForeground(Color.BLACK);
    lbEstado.setForeground(Color.BLACK);
    lbCEP.setForeground(Color.BLACK);

    botaoSalvar = new JButton("Salvar");
    botaoLimpar = new JButton("Limpar");

    botaoSalvar.setBounds(10, 230, 80, 20);
    botaoLimpar.setBounds(100, 230, 80, 20);

    container.add(botaoSalvar);
    container.add(botaoLimpar);

    tabela = new JTable();
    modelo = (DefaultTableModel) tabela.getModel();

    modelo.addColumn("ID");
    modelo.addColumn("Nome");
    modelo.addColumn("Cpf");
    modelo.addColumn("Telefone");
    modelo.addColumn("Data Nascimento");
    modelo.addColumn("Naturalidade");
    modelo.addColumn("Logradouro");
    modelo.addColumn("Numero");
    modelo.addColumn("Bairro");
    modelo.addColumn("Cidade");
    modelo.addColumn("Estado");

    preencherTabela();

    tabela.setBounds(10, 260, 760, 300);
    container.add(tabela);

    botaoApagar = new JButton("Excluir");
    botaoEditar = new JButton("Alterar");

    botaoApagar.setBounds(10, 580, 80, 20);
    botaoEditar.setBounds(100, 580, 80, 20);

    container.add(botaoApagar);
    container.add(botaoEditar);

    setSize(920, 762);
    setVisible(false);
    setLocationRelativeTo(null);

    botaoSalvar.addActionListener(e -> {
      salvar();
      limparTabela();
      preencherTabela();
    });

    botaoLimpar.addActionListener(e -> limpar());

    botaoEditar.addActionListener(e -> {
      alterar();
      limparTabela();
      preencherTabela();
    });

    botaoApagar.addActionListener(e -> {
      deletar();
      limparTabela();
      preencherTabela();
    });
  }


  private void salvar() {


    if (!txtNome.getText().equals("") && !txtLogradouro.getText().equals("")) {
//      Process process = Runtime.getRuntime().exec(
//              "curl -X POST http://localhost:8083/api/usuarios/post -H 'Content-Type: application/json' -d '{\"email\": \"santhiago@gmail.com\", \"senha\": \"teste\", \"confirmaSenha\": \"teste\", \"cargos\": \"Doador\" }'\n");
      try {
        var message = """
                {"nome":"San Thiago Teixeira de Barros", "tipoSangue":"A", "cpf":"072.094.703-01", "telefone":"(85) 99668-7731", "dataNascimento":"1998-06-16T15:53:16", "naturalidade":"RN","endereco":{"cep":"62903832", "logradouro":"Av. Porto Velho", "numero":4032, "complemento":"Certo ","bairro":"Henrique Jorge","cidade":"Fortaleza", "uf":"CE"}} 
                """;
        var client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8083/api/doadores/post"))
                .header("Content-Type", "application/json")
                .POST(BodyPublishers.ofString(message))
                .build();
        var httpResponse = client.send(httpRequest, BodyHandlers.discarding());

      } catch (IOException | InterruptedException e) {
        throw new RuntimeException(e);
      }

//        byte[] out = ("{\"nome\": \"San Thiago Teixeira de Barros\", \"tipoSangue\": \"A\"," +
//                "\"cpf\": \"072.094.703-01\", \"telefone\": \"(85) 99668-7731\", " +
//                "\"dataNascimento\": \"1998-06-16T15:53:16\", \"naturalidade\": \"RN\", " +
//                "\"endereco\": {\"cep\": \"62903832\", \"logradouro\": \"Av. Porto Velho\", " +
//                "\"numero\": 4032, \"complemento\": \"Certo \", \"bairro\": \"Henrique Jorge\"," +
//                " \"cidade\": \"Fortaleza\", \"uf\": \"CE\" }").getBytes(StandardCharsets.UTF_8);
//
//        http.setFixedLengthStreamingMode(out.length);
//        http.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
//        http.connect();
//        try (OutputStream os = http.getOutputStream()) {
//          os.write(out);
//        }

//
//      doadorService.adicionarDoador(new PessoaDTO(
//              this.txtNome.getText(),
//              TipoSangue.valueOf(this.cbTipoSangue.getName()),
//              this.txtCpf.getText(),
//              this.txtTelefone.getText(),
//              LocalDateTime.parse(this.txtDataNascimento.getText()),
//              UF.valueOf(this.cbNaturalidade.getName()),
//              new Endereco(this.txtLogradouro.getText(),
//                      Integer.parseInt(this.txtNumero.getText()),
//                      this.txtBairro.getText(),
//                      this.txtCidade.getText(),
//                      UF.valueOf(this.cbEstado.getName()),
//                      this.txtCep.getText())));
      JOptionPane.showMessageDialog(this, "Doador salvo com sucesso!");
      this.limpar();
    } else {
      JOptionPane.showMessageDialog(this, "Dados não informados corretamente.");
    }

  }

  private void alterar() {
//    Object obj = (Object) modelo.getValueAt(tabela.getSelectedRow(), tab)
  }

  private void preencherTabela() {
  }

  private void deletar() {
  }

  private void limpar() {
    this.txtNome.setText("");
    this.txtCpf.setText("");
    this.txtTelefone.setText("");
    this.txtDataNascimento.setText("");
    this.txtLogradouro.setText("");
    this.txtNumero.setText("");
    this.txtBairro.setText("");
    this.txtCidade.setText("");
    this.txtCep.setText("");
    this.cbEstado.setSelectedIndex(0);
    this.cbNaturalidade.setSelectedIndex(0);
    this.cbTipoSangue.setSelectedIndex(0);
  }

  private void limparTabela() {
    modelo.getDataVector().clear();
  }


}
