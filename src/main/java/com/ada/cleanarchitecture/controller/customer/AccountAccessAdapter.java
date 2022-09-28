package com.ada.cleanarchitecture.controller.customer;

import com.ada.cleanarchitecture.adapter.Adapter;
import com.ada.cleanarchitecture.cliente.Cliente;
import com.ada.cleanarchitecture.cliente.ClienteContaCorrente;
import com.ada.cleanarchitecture.cliente.conta.ContaCorrente;

public class AccountAccessAdapter implements Adapter<ClienteContaCorrente, Cliente> {

    @Override
    public ClienteContaCorrente adapt(Cliente c) {
        ContaCorrente conta = c.getConta();
        return new ClienteContaCorrente(c.getNome(),
                c.getStatus(),
                c.getDocumento(),
                conta.getBanco(),
                conta.getAgencia(),
                conta.getContaCorrente(),
                conta.getSaldo());
    }
}
