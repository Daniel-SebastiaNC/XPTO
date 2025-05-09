package br.com.XPTO.infra.exceptions;

public class CpfOrCnpjInvalidException extends RuntimeException {
    public CpfOrCnpjInvalidException(String message) {
        super(message);
    }
}
