package com.ada.cleanarchitecture.usecase.conta;

import com.ada.cleanarchitecture.annotations.UseCase;
import com.ada.cleanarchitecture.cliente.ClienteDepositoRequest;
import com.ada.cleanarchitecture.cliente.conta.ContaCorrente;
import com.ada.cleanarchitecture.gateway.repository.ContaCorrenteGateway;
import com.ada.cleanarchitecture.usecase.ApplicationUseCase;

import java.math.BigDecimal;

@UseCase
public class DepositoContaCliente implements ApplicationUseCase<ClienteDepositoRequest, ContaCorrente> {

    private final ContaCorrenteGateway contaCorrenteGateway;

    public DepositoContaCliente(ContaCorrenteGateway contaCorrenteGateway) {
        this.contaCorrenteGateway = contaCorrenteGateway;
    }

    @Override
    public ContaCorrente execute(ClienteDepositoRequest input) {
        ContaCorrente contaCorrente = input.getPara();
        return contaCorrenteGateway.findByContaCorrente(contaCorrente.getContaCorrente())
                .map(c -> deposita(input, c))
                .map(c -> contaCorrenteGateway.save(Math.toIntExact(c.getId()), c))
                .orElseThrow();
    }

    private ContaCorrente deposita(ClienteDepositoRequest input, ContaCorrente c) {
        BigDecimal total = c.getSaldo().add(input.getValor());
        c.setSaldo(total);
        return c;
    }
}
