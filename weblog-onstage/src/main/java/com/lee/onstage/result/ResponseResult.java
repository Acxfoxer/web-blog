package com.lee.onstage.result;

import com.fasterxml.jackson.annotation.JsonInclude;
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

    public static ResponseResult success(Integer code,String msg){
        ResponseResult result = new ResponseResult();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
    public static ResponseResult success(Integer code,String msg,Object data){
        ResponseResult result = new ResponseResult();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }
    public static ResponseResult error(Integer code,String msg){
        ResponseResult result = new ResponseResult();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
    public static ResponseResult error(String msg){
        ResponseResult result = new ResponseResult();
        result.setMsg(msg);
        return result;
    }
}
