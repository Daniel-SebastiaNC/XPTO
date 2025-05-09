package br.com.XPTO.infra.exceptions;

public class MustBeLinkedAccountException extends RuntimeException {
    public MustBeLinkedAccountException(String message) {
        super(message);
    }
}
