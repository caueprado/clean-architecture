package com.ada.cleanarchitecture.gateway.client;

public interface ClientGateway<T> {

    void doRequest(T request);
}
