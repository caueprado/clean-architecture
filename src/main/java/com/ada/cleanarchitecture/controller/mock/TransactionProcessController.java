package com.ada.cleanarchitecture.controller.mock;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;


@RestController
@RequestMapping("clean/transactions")
public class TransactionProcessController {

    @PostMapping
    public TransactionDTO process(final TransacaoRequest transacaoRequest) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        if (random.nextInt(0, 1000) < 900) {
            return new TransactionDTO(transacaoRequest.getOrigem(),
                    transacaoRequest.getDestino(),
                    transacaoRequest.getValor(),
                    transacaoRequest.getTipo());
        } else {
            throw new RuntimeException();
        }
    }
}
