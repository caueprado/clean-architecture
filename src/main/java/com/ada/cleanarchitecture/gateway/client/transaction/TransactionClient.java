package com.ada.cleanarchitecture.gateway.client.transaction;

import com.ada.cleanarchitecture.cliente.ClienteDepositoRequest;
import com.ada.cleanarchitecture.cliente.conta.transacao.Tipo;
import com.ada.cleanarchitecture.controller.mock.TransacaoRequest;
import com.ada.cleanarchitecture.controller.mock.TransactionDTO;
import com.ada.cleanarchitecture.controller.mock.TransactionProcessController;
import com.ada.cleanarchitecture.gateway.client.ClientGateway;

import java.math.BigDecimal;

public class TransactionClient implements ClientGateway<ClienteDepositoRequest, TransactionDTO> {

    private TransactionProcessController transactionProcessController;
    private TransactionAdapter transactionAdapter;

    public TransactionDTO doRequest(final TransacaoRequest request) {
        return transactionProcessController.process(request);
    }

    public TransactionDTO doRequest(ClienteDepositoRequest c) {
        return doRequest(transactionAdapter.adapt(c));
    }

    public TransactionDTO doRequest(String currentAccount, String currentAccountDestino, BigDecimal currentAmount, Tipo saque) {
        TransacaoRequest request = new TransacaoRequest(currentAccount, currentAccountDestino, currentAmount, saque);
        return transactionProcessController.process(request);
    }
}