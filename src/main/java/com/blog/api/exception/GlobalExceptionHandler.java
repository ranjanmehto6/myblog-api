package com.blog.api.exception;

//import org.springframework.web.bind.annotation.ControllerAdvice;
import com.blog.api.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse>resourceNotFoundExceptionHandler(ResourceNotFoundException ex) {

        String message = ex.getMessage();

        ApiResponse apiResponse = new ApiResponse(message,false);
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> methodArgumentNotValidException(MethodArgumentNotValidException ex){

        Map<String,String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error)->{

            String fieldName = ((FieldError)error).getField();
            String defaultMessage = error.getDefaultMessage();
            errors.put(fieldName,defaultMessage);

        });
        return new ResponseEntity<Map<String,String>>(errors,HttpStatus.OK);
    }
}
