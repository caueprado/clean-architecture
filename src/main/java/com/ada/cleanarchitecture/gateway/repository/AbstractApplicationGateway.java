package com.ada.cleanarchitecture.gateway.repository;

import com.ada.cleanarchitecture.gateway.database.ExternalGateway;

public class AbstractApplicationGateway<S, ID> implements ExternalGateway<S, ID> {

    private final ExternalGateway<S, ID> externalGateway;

    public AbstractApplicationGateway(ExternalGateway<S, ID> externalGateway) {
        this.externalGateway = externalGateway;
    }

    public S findById(ID id) {
        return this.externalGateway.findById(id);
    }

    public S update(ID id, S s) {
        return this.externalGateway.update(id, s);
    }

    public S delete(ID id) {
        return this.externalGateway.delete(id);
    }

    public S save(ID id, S s) {
        return this.externalGateway.save(id, s);
    }
}
