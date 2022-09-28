package com.ada.cleanarchitecture.gateway.client;

import com.ada.cleanarchitecture.controller.mock.TransactionDTO;

public interface ClientGateway<T, T1> {

    TransactionDTO doRequest(T request);
}
