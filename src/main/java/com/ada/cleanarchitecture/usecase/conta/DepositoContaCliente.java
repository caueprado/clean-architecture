package com.ada.cleanarchitecture.usecase.conta;

import com.ada.cleanarchitecture.annotations.UseCase;
import com.ada.cleanarchitecture.cliente.ClienteDepositoRequest;
import com.ada.cleanarchitecture.cliente.conta.ContaCorrente;
import com.ada.cleanarchitecture.controller.mock.TransactionDTO;
import com.ada.cleanarchitecture.gateway.client.transaction.TransactionClient;
import com.ada.cleanarchitecture.gateway.repository.ContaCorrenteGateway;
import com.ada.cleanarchitecture.usecase.ApplicationUseCase;

import java.math.BigDecimal;

@UseCase
public class DepositoContaCliente implements ApplicationUseCase<ClienteDepositoRequest, TransactionDTO> {

    private final ContaCorrenteGateway contaCorrenteGateway;

    private final TransactionClient transactionClient;

    public DepositoContaCliente(final ContaCorrenteGateway contaCorrenteGateway,
                                final TransactionClient transactionClient
    ) {
        this.contaCorrenteGateway = contaCorrenteGateway;
        this.transactionClient = transactionClient;
    }

    @Override
    public TransactionDTO execute(final ClienteDepositoRequest input) {
        ContaCorrente contaCorrente = input.getDe();
        return contaCorrenteGateway.findByContaCorrente(contaCorrente.getContaCorrente())
                .map(c -> deposita(input, c))
                .map(c -> transactionClient.doRequest(input))
                .orElseThrow();
    }

    private void doOperation(final ContaCorrente contaCorrente) {
        contaCorrenteGateway.findByContaCorrente(contaCorrente.getContaCorrente())
                .ifPresent(f -> {
                    contaCorrenteGateway.save(Math.toIntExact(f.getId()), contaCorrente);
                });
    }

    /**
     * Como ppodemos melhorar essa fun~çao e evitar duplicidade de código
     *
     * @param input
     * @param contaCorrente
     * @return
     */
    private ContaCorrente deposita(ClienteDepositoRequest input, ContaCorrente contaCorrente) {
        if (input.getDe().getContaCorrente().equals(input.getPara().getContaCorrente())) {
            BigDecimal total = contaCorrente.getSaldo().add(input.getValor());

            contaCorrente.setSaldo(total);
            doOperation(contaCorrente);
        } else {
            ContaCorrente contaDe = input.getDe();
            ContaCorrente contaPara = input.getPara();

            BigDecimal deResult = contaDe.getSaldo().subtract(input.getValor());
            contaDe.setSaldo(deResult);
            doOperation(contaDe);

            BigDecimal paraResult = contaPara.getSaldo().subtract(input.getValor());
            contaPara.setSaldo(paraResult);
            doOperation(contaPara);

            BigDecimal totalPara = contaCorrente.getSaldo().add(input.getValor());
            contaCorrente.setSaldo(totalPara);
        }
        return contaCorrente;
    }
}
