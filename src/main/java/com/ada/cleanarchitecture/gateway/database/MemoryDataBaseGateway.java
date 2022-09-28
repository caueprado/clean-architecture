package com.ada.cleanarchitecture.gateway.database;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MemoryDataBaseGateway<T, ID> implements ExternalGateway<T, ID> {

    private final Map<ID, T> memoryData;

    public MemoryDataBaseGateway() {
        this.memoryData = new ConcurrentHashMap<>();
    }

    public T findById(ID id) {
        return this.memoryData.getOrDefault(id, null);
    }

    @Override
    public T update(ID id, T s) {
        return this.memoryData.replace(id, s);
    }

    @Override
    public T delete(ID id) {
        T s = findById(id);
        if (s != null) {
            return this.memoryData.remove(id);
        }

        return null;
    }

    @Override
    public T save(ID id, T s) {
        return this.memoryData.putIfAbsent(id, s);
    }
}
