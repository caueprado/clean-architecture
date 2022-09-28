package com.ada.cleanarchitecture.cliente;

import java.math.BigDecimal;

public class ClienteContaCorrente {

    private String nome;
    private String status;
    private String documento;
    private String banco;
    private String agencia;
    private String contaCorrente;
    private BigDecimal saldo;

    public ClienteContaCorrente() {
    }

    public ClienteContaCorrente(String nome, String status, String documento, String banco, String agencia, String contaCorrente, BigDecimal saldo) {
        this.nome = nome;
        this.status = status;
        this.documento = documento;
        this.agencia = agencia;
        this.contaCorrente = contaCorrente;
        this.saldo = saldo;
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

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getContaCorrente() {
        return contaCorrente;
    }

    public void setContaCorrente(String contaCorrente) {
        this.contaCorrente = contaCorrente;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
}
