package com.ada.cleanarchitecture.cliente.conta;

import com.ada.cleanarchitecture.cliente.conta.transacao.Tipo;

import java.math.BigDecimal;

public class CustomerWithdrawalRequest {
    private String origem;
    private String contaCorrenteDestino;
    private Tipo tipo;
    private BigDecimal amount;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public CustomerWithdrawalRequest() {
    }

    public CustomerWithdrawalRequest(String origem, String contaCorrenteDestino, Tipo tipo, BigDecimal amount) {
        this.origem = origem;
        this.contaCorrenteDestino = contaCorrenteDestino;
        this.tipo = tipo;
        this.amount = amount;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getContaCorrenteDestino() {
        return contaCorrenteDestino;
    }

    public void setContaCorrenteDestino(String contaCorrenteDestino) {
        this.contaCorrenteDestino = contaCorrenteDestino;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
}
