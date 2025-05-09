package br.com.XPTO.infra.exceptions;

public class TelephoneInvalidException extends RuntimeException {
    public TelephoneInvalidException(String message) {
        super(message);
    }
}
