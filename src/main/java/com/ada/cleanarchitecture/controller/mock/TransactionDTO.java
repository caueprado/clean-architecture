package com.ada.cleanarchitecture.controller.mock;

import com.ada.cleanarchitecture.cliente.conta.transacao.Tipo;

import java.math.BigDecimal;

public class TransactionDTO {

    private String origem;
    private String destino;
    private BigDecimal valor;
    private Tipo tipo;

    public TransactionDTO() {
    }

    public TransactionDTO(String origem, String destino, BigDecimal valor, Tipo tipo) {
        this.origem = origem;
        this.destino = destino;
        this.valor = valor;
        this.tipo = tipo;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
}
