package com.ada.cleanarchitecture.cliente;

import com.ada.cleanarchitecture.cliente.conta.ContaCorrente;
import java.math.BigDecimal;

public class ClienteDepositoRequest {

    private ContaCorrente de;
    private ContaCorrente para;
    private BigDecimal valor;

    public ClienteDepositoRequest(ContaCorrente de, ContaCorrente para, BigDecimal valor) {
        this.de = de;
        this.para = para;
        this.valor = valor;
    }

    public ClienteDepositoRequest() {
    }

    public ContaCorrente getDe() {
        return de;
    }

    public void setDe(ContaCorrente de) {
        this.de = de;
    }

    public ContaCorrente getPara() {
        return para;
    }

    public void setPara(ContaCorrente para) {
        this.para = para;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
