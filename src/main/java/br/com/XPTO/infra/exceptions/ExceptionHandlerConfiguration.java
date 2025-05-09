package br.com.XPTO.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandlerConfiguration {

    @ExceptionHandler(DataNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handlerDataNotFoundException(DataNotFoundException ex) {
        HashMap<String, String> error = new HashMap<>();
        error.put("message: ", ex.getMessage());
        error.put("error: ", "Data Not Found");

        return error;
    }

    @ExceptionHandler(NotEnoughMoneyAccountException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public Map<String, String> handlerNotEnoughMoneyAccountException(NotEnoughMoneyAccountException ex){
        HashMap<String, String> error = new HashMap<>();
        error.put("message: ", ex.getMessage());
        error.put("error: ", "Not Enough Money");

        return error;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handlerArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            errors.put(((FieldError) error).getField(), error.getDefaultMessage());
        });

        return errors;
    }

    @ExceptionHandler(CpfOrCnpjInvalidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handlerCpfOrCnpjInvalid(CpfOrCnpjInvalidException ex) {
        HashMap<String, String> error = new HashMap<>();
        error.put("message: ", ex.getMessage());
        error.put("error: ", "CPF or CNPJ Invalid");

        return error;
    }

    @ExceptionHandler(MustBeLinkedAccountException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handlerMustBeLinkedAccountException(MustBeLinkedAccountException ex) {
        HashMap<String, String> error = new HashMap<>();
        error.put("message: ", ex.getMessage());
        error.put("error: ", "No Linked Account");

        return error;
    }

    @ExceptionHandler(NoMovementAccountException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public Map<String, String> handlerNoMovementAccountException(NoMovementAccountException ex) {
        HashMap<String, String> error = new HashMap<>();
        error.put("message: ", ex.getMessage());
        error.put("error: ", "No Movement Account");

        return error;
    }

    @ExceptionHandler(TelephoneInvalidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handlerTelephoneInvalidException(TelephoneInvalidException ex) {
        HashMap<String, String> error = new HashMap<>();
        error.put("message: ", ex.getMessage());
        error.put("error: ", "Telephone Invalid");

        return error;
    }

    @ExceptionHandler(AccountAlreadyLinked.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handlerAccountAlreadyLinked(AccountAlreadyLinked ex) {
        HashMap<String, String> error = new HashMap<>();
        error.put("message: ", ex.getMessage());
        error.put("error: ", "Account Already Linked");

        return error;
    }
}
