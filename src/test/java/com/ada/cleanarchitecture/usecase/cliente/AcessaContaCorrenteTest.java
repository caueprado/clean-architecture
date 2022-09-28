package com.ada.cleanarchitecture.usecase.cliente;

import com.ada.cleanarchitecture.cliente.Cliente;
import com.ada.cleanarchitecture.cliente.ClienteContaCorrente;
import com.ada.cleanarchitecture.cliente.conta.ContaCorrente;
import com.ada.cleanarchitecture.controller.request.ClienteAcessaContaRequest;
import com.ada.cleanarchitecture.gateway.database.ExternalGateway;
import com.ada.cleanarchitecture.gateway.database.MemoryDataBaseGateway;
import com.ada.cleanarchitecture.gateway.repository.ClienteGateway;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AcessaContaCorrenteTest {

    private final static String EXPECTED_CPF = "22456878496";

    private AcessaContaCorrente acessaContaCorrente;

    private ClienteGateway clienteGateway;

    @Test
    public void dadoUmClienteComContaCorrenteAtiva_QuandoEntrarComCPF_EntaoRetornaremosAContaCorrente() {
        String senhaInserida = "123456";
        ContaCorrente contaCorrenteEsperada = criaContaCorrente();

        Cliente clienteEsperado = criaCliente(senhaInserida, contaCorrenteEsperada);
        ExternalGateway<Cliente, Integer> gateway = new MemoryDataBaseGateway<>();

        gateway.save(Math.toIntExact(clienteEsperado.getId()), clienteEsperado);

        var request = new ClienteAcessaContaRequest(123, clienteEsperado.getDocumento(), senhaInserida);
        clienteGateway = new ClienteGateway(gateway);
        acessaContaCorrente = new AcessaContaCorrente(clienteGateway);

        ClienteContaCorrente result = acessaContaCorrente.execute(request);

        assert result.getContaCorrente().equals(contaCorrenteEsperada.getContaCorrente());
        assert result.getAgencia().equals(contaCorrenteEsperada.getAgencia());
        assert result.getSaldo().equals(contaCorrenteEsperada.getSaldo());
    }

    private Cliente criaCliente(String senhaInserida, ContaCorrente contaCorrenteEsperada) {
        return new Cliente(123l,
                "Teste",
                "Ativo",
                LocalDate.now(),
                EXPECTED_CPF,
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

    /**
     * Usuario nao existe
     */
    @Test
    public void dadoUmClienteComContaCorrenteAtiva_QuandoEntrarComCPFESenhaErrada_EntaoRetornaraErroSenhaInvalida() {
        String senhaInserida = "123456";
        String senhaCorreta = "12345";

        // 5 - cria uma ContaCorrente esperada
        ContaCorrente contaCorrenteEsperada = criaContaCorrente();

        //passo 6
        Cliente clienteEsperado = criaCliente(senhaCorreta, contaCorrenteEsperada);

        //  insere no banco
//        clienteGateway.save(clienteEsperado);

        var request = new ClienteAcessaContaRequest(clienteEsperado.getDocumento(), senhaInserida);

        try {
            acessaContaCorrente.execute(request);
        } catch (Exception e) {
//            Assertions.assertThat(e.getClass()).isEqualTo(IncorrectPasswordException.class);
        }
    }
}
