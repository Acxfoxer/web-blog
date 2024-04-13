package com.lee.onstage.exception;

import com.lee.onstage.constants.ResultCode;
import lombok.Getter;

/**
 * 自定义业务异常
 * @author Acxfoxer
 * @Date 20240413
 */
@Getter
public final class BusinessException extends RuntimeException{
    /**
     * 业务响应失败状态码
     */
    private final Integer code = ResultCode.ERROR.getCode();

    /**
     * 业务响应失败信息
     */
    private final String message;

    public BusinessException(String message){
        this.message=message;
    }
}
