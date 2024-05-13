package com.arbahi.examsmanagement.config;


import com.arbahi.examsmanagement.Exceptions.AppException;
import com.arbahi.examsmanagement.dto.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(value = {AppException.class})
    @ResponseBody
    public ResponseEntity<ErrorDTO> handleException(AppException ex) {
        return ResponseEntity.status(ex.getStatus())
                .body(new ErrorDTO(ex.getMessage()));
    }
}
