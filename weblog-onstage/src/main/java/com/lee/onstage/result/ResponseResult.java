package com.lee.onstage.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.lee.onstage.constants.ResultCode;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
public class ResponseResult<T> implements Serializable {
    private static final long serialVersionUID = -1L;
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 提示信息
     */
    private String msg;
    /**
     * 查到的数据
     */
    private T data;

    public ResponseResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public ResponseResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> ResponseResult<T> success(Integer code,String msg){
        return buildResult(code,msg,null);
    }
    public static <T> ResponseResult<T> success(T data){
        return  buildResult(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMsg(),data);
    }
    public static <T> ResponseResult<T> success(Integer code,String msg,T data){
        return buildResult(code,msg,data);
    }

    public static <T> ResponseResult<T> success(){
        return  buildResult(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMsg(),null);
    }
    public static <T> ResponseResult<T> error(Integer code,String msg){
       return buildResult(code,msg,null);
    }
    public static <T> ResponseResult<T> error(String msg){
        return buildResult(null,msg,null);
    }
    private static <T> ResponseResult<T> buildResult(Integer code,String msg,T data){
        ResponseResult<T> result =new ResponseResult<>();
        result.setCode(code);
        result.setData(data);
        result.setMsg(msg);
        return result;
    }
}
