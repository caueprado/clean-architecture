package com.ada.cleanarchitecture.cliente;

import com.ada.cleanarchitecture.cliente.conta.ContaCorrente;
import java.math.BigDecimal;

public class ClienteDepositoRequest {

    private ContaCorrente para;
    private BigDecimal valor;

    public ClienteDepositoRequest(ContaCorrente para, BigDecimal valor) {
        this.para = para;
        this.valor = valor;
    }

    public ClienteDepositoRequest() {
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
