package ks46team04.exception.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ks46team04.exception.*;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(value = {NotEnoughStockException.class})
	 public String exceptionHandler(RuntimeException e) {
        return e.getMessage();
    }
}
