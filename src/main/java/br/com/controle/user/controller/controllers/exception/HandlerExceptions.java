package br.com.controle.user.controller.controllers.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class HandlerExceptions {

    private final Logger logger = LoggerFactory.getLogger(HandlerExceptions.class);

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handlerNoSuchElement(NoSuchElementException noSuchElementException) {
        String message = "Resource ID not found";
        logger.error(message, noSuchElementException);
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }
}
