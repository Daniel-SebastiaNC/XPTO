package br.com.XPTO.infra.exceptions;

public class NoMovementAccountException extends RuntimeException {
    public NoMovementAccountException(String message) {
        super(message);
    }
}
