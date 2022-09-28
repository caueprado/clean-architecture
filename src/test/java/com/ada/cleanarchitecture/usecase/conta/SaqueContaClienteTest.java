package com.ada.cleanarchitecture.usecase.conta;

import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;

public class SaqueContaClienteTest {

    @Test
    public void testeSucesso() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        System.out.println(random.nextInt(0, 1000));
        System.out.println(random.nextInt(0, 1000));
        System.out.println(random.nextInt(0, 1000));
        System.out.println(random.nextInt(0, 1000));
    }

    @Test
    public void testeErro() {

    }
}
