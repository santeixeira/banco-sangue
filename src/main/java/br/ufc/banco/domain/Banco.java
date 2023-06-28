package br.ufc.banco.domain;

import jakarta.persistence.*;

@Entity
public class Banco {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bancoId;
    private String nomeFantasia;
    @JoinColumn(name = "enderecoId", referencedColumnName = "enderecoId")
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "estoqueId", referencedColumnName = "estoqueId")
    private Estoque estoque;


}
