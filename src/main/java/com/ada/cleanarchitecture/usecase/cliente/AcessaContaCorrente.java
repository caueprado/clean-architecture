package com.ada.cleanarchitecture.usecase.cliente;

import com.ada.cleanarchitecture.annotations.UseCase;
import com.ada.cleanarchitecture.cliente.Cliente;
import com.ada.cleanarchitecture.controller.request.ClienteAcessaContaRequest;
import com.ada.cleanarchitecture.exception.IncorrectPasswordException;
import com.ada.cleanarchitecture.gateway.repository.ClienteGateway;
import com.ada.cleanarchitecture.usecase.ApplicationUseCase;

import static java.util.Optional.of;

@UseCase
public class AcessaContaCorrente implements ApplicationUseCase<ClienteAcessaContaRequest, Cliente> {

    private final ClienteGateway clienteGateway;

    public AcessaContaCorrente(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }

    @Override
    public Cliente execute(ClienteAcessaContaRequest input) {
        Cliente clienteAtual = clienteGateway
                .findById(input.getId());

        if (!clienteAtual.getSenha().equals(input.getSenha())) {
            throw new IncorrectPasswordException();
        }

        return of(clienteAtual)
                .orElseThrow();
    }
}