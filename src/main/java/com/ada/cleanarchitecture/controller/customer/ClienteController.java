package com.ada.cleanarchitecture.controller.customer;

import com.ada.cleanarchitecture.cliente.ClienteContaCorrente;
import com.ada.cleanarchitecture.controller.request.ClienteAcessaContaRequest;
import com.ada.cleanarchitecture.usecase.cliente.AcessaContaCorrente;

import java.util.Optional;

public class ClienteController {

    private final AcessaContaCorrente acessaContaCorrente;
    private final AccountAccessAdapter adapter;

    public ClienteController(AcessaContaCorrente acessaContaCorrente, AccountAccessAdapter adapter) {
        this.acessaContaCorrente = acessaContaCorrente;
        this.adapter = adapter;
    }

    public ClienteContaCorrente auth(final ClienteAcessaContaRequest request) {
        return Optional.of(acessaContaCorrente.execute(request))
                .map(adapter::adapt)
                .orElseThrow();
    }
}
