package com.ada.cleanarchitecture.gateway.repository;

import com.ada.cleanarchitecture.cliente.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteGateway extends CrudRepository<Cliente, Integer> {
}
