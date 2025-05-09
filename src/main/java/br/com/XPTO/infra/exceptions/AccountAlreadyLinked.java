package br.com.XPTO.infra.exceptions;

public class AccountAlreadyLinked extends RuntimeException {
    public AccountAlreadyLinked(String message) {
        super(message);
    }
}
