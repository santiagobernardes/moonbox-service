package br.com.moonbox.moonboxservice.util.exception;

import org.springframework.http.HttpStatus;

public abstract class ApiException extends RuntimeException {

    public abstract HttpStatus getHttpStatus();
}
