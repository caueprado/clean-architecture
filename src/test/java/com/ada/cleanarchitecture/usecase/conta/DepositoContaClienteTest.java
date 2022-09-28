package com.ada.cleanarchitecture.usecase.conta;

import com.ada.cleanarchitecture.cliente.Cliente;
import com.ada.cleanarchitecture.cliente.ClienteDepositoRequest;
import com.ada.cleanarchitecture.cliente.conta.ContaCorrente;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DepositoContaClienteTest {

    private DepositoContaCliente depositoContaCliente;

    @Test
    public void dadoUmClienteComUmaContaValida_QuandoSolicitaFazerUmDeposito_EntaoDeveInserirDinheiroComSucesso() {
        BigDecimal quantia = new BigDecimal(50_000);
        ContaCorrente de = criaContaCorrente();
        ContaCorrente conta = criaContaCorrente();

        ClienteDepositoRequest request = new ClienteDepositoRequest(de, conta, quantia);
        depositoContaCliente.execute(request);
    }

    @Test
    public void dadoUmClienteComUmaContaValida_QuandoSolicitaFazerUmDeposito_EntaoOcorreUmErroValorIncorreto() {

    }

    private Cliente criaCliente(String senhaInserida, ContaCorrente contaCorrenteEsperada) {
        return new Cliente(123L, "Teste",
                "Ativo",
                LocalDate.now(),
                "123456454",
                contaCorrenteEsperada,
                senhaInserida);
    }

    private ContaCorrente criaContaCorrente() {
        return new ContaCorrente(
                "Banco",
                "1234",
                "1234567",
                new BigDecimal(0.00)
        );
    }
}
