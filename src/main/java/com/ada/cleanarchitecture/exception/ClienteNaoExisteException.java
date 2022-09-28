package com.ada.cleanarchitecture.exception;

public class ClienteNaoExisteException extends RuntimeException {

    public ClienteNaoExisteException() {
    }

    public ClienteNaoExisteException(String message) {
        super(message);
    }
}
