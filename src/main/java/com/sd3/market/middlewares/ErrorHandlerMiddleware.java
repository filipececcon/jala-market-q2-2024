package com.sd3.market.middlewares;

import com.sd3.market.exceptions.ProductException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@ControllerAdvice
public class ErrorHandlerMiddleware {

    @ExceptionHandler(ProductException.class)
    public ResponseEntity<String> ProductExceptionHandle(ProductException ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
