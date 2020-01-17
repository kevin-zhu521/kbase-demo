package com.kbase.demo.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ValidationException;

/**
 * 全局异常捕获
 *
 * @author <a href="yogurt_lei@foxmail.com">Yogurt_lei</a>
 * @version v1.0 , 2018-09-05 10:05
 */
@Slf4j
@ResponseStatus(HttpStatus.OK)
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 参数校验异常
     */
    @ExceptionHandler({RuntimeException.class})
    public String validateExceptionHandler(Exception ex) {
        ex.printStackTrace();
        return "failed";
    }

}
