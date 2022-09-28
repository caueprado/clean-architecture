package com.ada.cleanarchitecture.gateway.client.transaction;

import com.ada.cleanarchitecture.adapter.Adapter;
import com.ada.cleanarchitecture.cliente.ClienteDepositoRequest;
import com.ada.cleanarchitecture.cliente.conta.transacao.Tipo;
import com.ada.cleanarchitecture.controller.mock.TransacaoRequest;

public class TransactionAdapter implements Adapter<TransacaoRequest, ClienteDepositoRequest> {
    @Override
    public TransacaoRequest adapt(ClienteDepositoRequest c) {
        return new TransacaoRequest(
                c.getDe().getContaCorrente(),
                c.getPara().getContaCorrente(),
                c.getValor(),
                Tipo.DEPOSITO);
    }
}
