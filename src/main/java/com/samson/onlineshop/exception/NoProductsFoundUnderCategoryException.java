package com.samson.onlineshop.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "No Products Found Under this Category!")
public class NoProductsFoundUnderCategoryException extends RuntimeException {
    private static final long serialVersionUID = 3935230281455340039L;
}
