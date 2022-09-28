package com.ada.cleanarchitecture.gateway.repository;

import com.ada.cleanarchitecture.cliente.conta.ContaCorrente;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ContaCorrenteGateway extends CrudRepository<ContaCorrente, Integer> {
    Optional<ContaCorrente> findByContaCorrente(String contaCorrente);
}
