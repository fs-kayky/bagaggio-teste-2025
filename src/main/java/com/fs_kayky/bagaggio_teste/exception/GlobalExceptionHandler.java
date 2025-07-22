package com.fs_kayky.bagaggio_teste.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

// Indica que essa classe vai tratar exceções de toda a API
@RestControllerAdvice
public class GlobalExceptionHandler {

    // Trata erros de validação (ex: campos obrigatórios)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        // Para cada erro encontrado, coloca no mapa o campo e a mensagem
        ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

        // Retorna status 400 e os erros
        return ResponseEntity.badRequest().body(errors);

    }


}
