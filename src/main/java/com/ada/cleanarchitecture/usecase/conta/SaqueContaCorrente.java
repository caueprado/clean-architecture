package com.ada.cleanarchitecture.usecase.conta;

import com.ada.cleanarchitecture.annotations.UseCase;
import com.ada.cleanarchitecture.cliente.conta.AccountAfterWithdrawal;
import com.ada.cleanarchitecture.cliente.conta.CustomerWithdrawalRequest;
import com.ada.cleanarchitecture.cliente.conta.transacao.Tipo;
import com.ada.cleanarchitecture.gateway.client.transaction.TransactionClient;
import com.ada.cleanarchitecture.gateway.repository.ContaCorrenteGateway;
import com.ada.cleanarchitecture.usecase.ApplicationUseCase;

import java.math.BigDecimal;

@UseCase
public class SaqueContaCorrente implements ApplicationUseCase<CustomerWithdrawalRequest, AccountAfterWithdrawal> {

    private final ContaCorrenteGateway contaCorrenteGateway;

    private final TransactionClient transactionClient;

    public SaqueContaCorrente(ContaCorrenteGateway contaCorrenteGateway, TransactionClient transactionClient) {
        this.contaCorrenteGateway = contaCorrenteGateway;
        this.transactionClient = transactionClient;
    }

    @Override
    public AccountAfterWithdrawal execute(CustomerWithdrawalRequest input) {
        String currentAccount = input.getOrigem();
        String currentAccountDestino = input.getContaCorrenteDestino();
        return contaCorrenteGateway.findByContaCorrente(currentAccount)
                .map(c -> {
                    if (input.getAmount().compareTo(c.getSaldo()) > 0) {
                        throw new RuntimeException("Invalid amount error 400");
                    }
                    BigDecimal currentAmount = c.getSaldo().subtract(input.getAmount());
                    c.setSaldo(currentAmount);
                    transactionClient.doRequest(currentAccount, currentAccountDestino, currentAmount, Tipo.SAQUE);
                    return contaCorrenteGateway.save(c);
                })
                .map(c -> new AccountAfterWithdrawal(c.getSaldo()))
                .orElseThrow(() -> new RuntimeException("Account not found 404"));
    }
}
