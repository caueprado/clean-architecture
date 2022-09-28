package com.ada.cleanarchitecture.cliente.conta;

import java.math.BigDecimal;

public class ContaCorrente {

 private Long id;

    private String banco;
    private String agencia;
    private String contaCorrente;
    private BigDecimal saldo;

    public ContaCorrente(String banco, String agencia, String contaCorrente, BigDecimal saldo) {
        this.banco = banco;
        this.agencia = agencia;
        this.contaCorrente = contaCorrente;
        this.saldo = saldo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
