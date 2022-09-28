package com.ada.cleanarchitecture.cliente;

import com.ada.cleanarchitecture.cliente.conta.ContaCorrente;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nome;
    private String status;
    private LocalDate entrada;
    private String documento;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "conta_id")
    private ContaCorrente conta;

    private String senha;

    public Cliente(Long id, String nome, String status, LocalDate entrada, String documento, ContaCorrente conta, String senha) {
        this.id = id;
        this.nome = nome;
        this.status = status;
        this.entrada = entrada;
        this.documento = documento;
        this.conta = conta;
        this.senha = senha;
    }

    public Cliente() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getEntrada() {
        return entrada;
    }

    public void setEntrada(LocalDate entrada) {
        this.entrada = entrada;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public ContaCorrente getConta() {
        return conta;
    }

    public void setConta(ContaCorrente conta) {
        this.conta = conta;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
