package com.ada.cleanarchitecture.usecase.conta;

import com.ada.cleanarchitecture.annotations.UseCase;
import com.ada.cleanarchitecture.cliente.ClienteExtratoRequest;
import com.ada.cleanarchitecture.cliente.conta.transacao.CustomerTransactions;
import com.ada.cleanarchitecture.usecase.ApplicationUseCase;

@UseCase
public class ExtratoContaCorrente implements ApplicationUseCase<ClienteExtratoRequest, CustomerTransactions> {

    @Override
    public CustomerTransactions execute(ClienteExtratoRequest input) {
        return null;
    }
}
