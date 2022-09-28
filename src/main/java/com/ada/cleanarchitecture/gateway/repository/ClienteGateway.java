package com.ada.cleanarchitecture.gateway.repository;

import com.ada.cleanarchitecture.cliente.Cliente;
import com.ada.cleanarchitecture.gateway.database.ExternalGateway;

public class ClienteGateway extends AbstractApplicationGateway<Cliente, Integer> {

    public ClienteGateway(ExternalGateway externalGateway) {
        super(externalGateway);
    }
}
