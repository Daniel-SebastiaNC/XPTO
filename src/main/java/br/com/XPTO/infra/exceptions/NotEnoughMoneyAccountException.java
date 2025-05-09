package br.com.XPTO.infra.exceptions;

public class NotEnoughMoneyAccountException extends RuntimeException {
    public NotEnoughMoneyAccountException(String message) {
        super(message);
    }
}
