package com.ada.cleanarchitecture.cliente.conta.transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transacao {

    private Long id;
    private String origem;
    private String destino;
    private LocalDateTime data;
    private BigDecimal valor;
    private Tipo tipo;

    public Transacao() {
    }

    public Transacao(Long id, String origem, String destino, LocalDateTime data, BigDecimal valor, Tipo tipo) {
        this.id = id;
        this.origem = origem;
        this.destino = destino;
        this.data = data;
        this.valor = valor;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
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
