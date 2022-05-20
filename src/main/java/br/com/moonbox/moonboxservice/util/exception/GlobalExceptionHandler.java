package br.com.moonbox.moonboxservice.util.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<ErrorDto> handleAllExceptions(GenericException exception) {
        ErrorDto errorDto = ErrorDto.builder()
                .code(exception.getCode())
                .message(exception.getMessage())
                .detail(exception.getDetail())
                .build();
        return new ResponseEntity<>(errorDto, exception.getHttpStatus());
    }

    @ExceptionHandler
    public final ResponseEntity<ErrorDto> handleDuplicateKeyException(SQLIntegrityConstraintViolationException ex) {
        log.error(ex.getLocalizedMessage());
        ErrorDto errorDto = ErrorDto.builder().message(ex.getMessage()).build();
        return new ResponseEntity<>(errorDto, HttpStatus.CONFLICT);
    }

    @Override
    public final ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.error(ex.getMessage());
        List<ErrorDto> errorDtoList = ex.getBindingResult().getAllErrors().stream().map(error -> ErrorDto.builder()
                        .detail(Arrays.stream(error.toString().split(";")).findFirst().get())
                        .message(error.getDefaultMessage())
                        .build())
                .collect(Collectors.toList());
        return new ResponseEntity<>(errorDtoList, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
            HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.error(ex.getLocalizedMessage(), ex);
        ErrorDto errorDto = ErrorDto.builder()
                .message(ex.getMessage())
                .build();
        return new ResponseEntity<>(errorDto, HttpStatus.METHOD_NOT_ALLOWED);
    }
}
