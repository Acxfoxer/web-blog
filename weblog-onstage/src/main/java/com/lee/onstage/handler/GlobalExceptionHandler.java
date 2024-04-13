package com.lee.onstage.handler;

import com.lee.onstage.exception.BusinessException;
import com.lee.onstage.result.ResponseResult;
import io.swagger.models.Response;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 * @author Acxfoxer
 * @Date 20240413
 */
@RestControllerAdvice
public class GlobalExceptionHandler{
    /**
     * 处理义务异常
     * @param e BusinessException
     * @return ResponseResult<?>
     */
    @ExceptionHandler(value = BusinessException.class)
    public ResponseResult<?> handlerBusinessException(BusinessException e){
        return ResponseResult.error(e.getMessage());
    }

    /**
     * 处理非法参数异常
     * @param e MethodArgumentNotValidException
     * @return ResponseResult<?>
     */
    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseResult<?> handleIllegalArgumentException(IllegalArgumentException e){
        return ResponseResult.error(e.getMessage());
    }

    /**
     * 方法传参异常
     * @param e MethodArgumentNotValidException
     * @return ResponseResult<?>
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseResult<?> handlerMethodArgumentNotValidException(MethodArgumentNotValidException e){
        return ResponseResult.error(e.getMessage());
    }
}
