package com.ada.cleanarchitecture.usecase.conta;

import com.ada.cleanarchitecture.annotations.UseCase;
import com.ada.cleanarchitecture.cliente.ClienteExtratoRequest;
import com.ada.cleanarchitecture.cliente.conta.AccountAfterWithdrawal;
import com.ada.cleanarchitecture.usecase.ApplicationUseCase;

@UseCase
public class SaqueContaCorrente implements ApplicationUseCase<ClienteExtratoRequest, AccountAfterWithdrawal> {

    @Override
    public AccountAfterWithdrawal execute(ClienteExtratoRequest input) {
        return null;
    }
}
