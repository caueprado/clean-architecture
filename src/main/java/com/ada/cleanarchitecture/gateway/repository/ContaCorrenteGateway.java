package com.ada.cleanarchitecture.gateway.repository;

import com.ada.cleanarchitecture.cliente.conta.ContaCorrente;
import com.ada.cleanarchitecture.gateway.database.ExternalGateway;

import java.util.Optional;

public class ContaCorrenteGateway extends AbstractApplicationGateway<ContaCorrente, Integer> {

    public ContaCorrenteGateway(ExternalGateway<ContaCorrente, Integer> externalGateway) {
        super(externalGateway);
    }

    public Optional<ContaCorrente> findByContaCorrente(String contaCorrente) {
        return null;
    }
}
