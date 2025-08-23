package com.lian.marketing.paymentmicroservice.infrastructure.driving.http.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GeneralControllerAdvisor {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionResponse(
                        HttpStatus.BAD_REQUEST.toString(),
                        HttpStatus.BAD_REQUEST.value(),
                        exception.getBindingResult().getAllErrors().get(0).getDefaultMessage(),
                        java.time.LocalDateTime.now(),
                        "METHOD_ARGUMENT_NOT_VALID_EXCEPTION"
                ));
    }
}
