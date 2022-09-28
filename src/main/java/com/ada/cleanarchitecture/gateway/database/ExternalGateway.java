package com.ada.cleanarchitecture.gateway.database;

public interface ExternalGateway<T, ID> {

    T findById(ID id);

    T update(ID id, T s);

    T delete(ID id);

    T save(ID id, T s);
}
