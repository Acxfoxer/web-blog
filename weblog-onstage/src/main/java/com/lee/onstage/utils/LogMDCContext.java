package com.lee.onstage.utils;

import cn.hutool.core.lang.generator.SnowflakeGenerator;
import com.alibaba.fastjson2.JSON;
import com.alibaba.ttl.TransmittableThreadLocal;
import io.netty.util.internal.StringUtil;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;
import java.util.Optional;

/**
 * 日志上下文对象
 * @Author lee
 * @Date 2024/4/1
 */
@Data
public class LogMDCContext{
    private static final String DEFAULT_SPAN_ID="0";
    private static final String DEFAULT_PARENT_SPAN_ID="0";
    private String traceId;
    private String spanId;
    private String parentSpanId;
    private String ip;

    private static TransmittableThreadLocal<LogMDCContext> local = new TransmittableThreadLocal<>();


    public static void parseContext(String param){
        //序列化对象
        LogMDCContext context = JSON.to(LogMDCContext.class, param);
        local.set(context);
        //更新spanId跟parentSpanId
        nextSpan();
    }

    /**
     * 更新spanId跟parentSpanId
     */
    private static void nextSpan() {
        if(StringUtils.isBlank(getContext().getSpanId())){
            getContext().setSpanId(DEFAULT_SPAN_ID);
            getContext().setParentSpanId(DEFAULT_PARENT_SPAN_ID);
            return;
        }
        String spanId = getContext().getSpanId();
        getContext().setParentSpanId(spanId);
        if(spanId.contains(".")){
            int pos = spanId.lastIndexOf(".");
            String afterIncreSpanId=pos==spanId.length()-1?String.valueOf(Integer.parseInt(spanId.substring(pos + 1)) + 1)
                    :String.valueOf(Integer.parseInt(spanId.substring(0,spanId.length()-1)));
            getContext().setSpanId(afterIncreSpanId);
        }else {
            getContext().setSpanId(String.valueOf(Integer.parseInt(spanId)+1));
        }
    }

    /**
     * 初始化上下文对象及IP
     * @param request HttpServletRequest 请求
     */
    public static void initContext(HttpServletRequest request){
        initContext();
        LogMDCContext logMDCContext = getContext();
        //根据请求解析请求IP
        logMDCContext.setIp(IPUtil.getIpAddr(request));
        setContext(logMDCContext);
    }

    /**
     * 初始化上下文对象
     */
    public static void initContext(){
        LogMDCContext logMDCContext = new LogMDCContext();
        initContextParam(logMDCContext);
        setContext(logMDCContext);
    }


    /**
     * 初始化上下文对象的各类参数
     * @param logMDCContext
     */
    private static void initContextParam(LogMDCContext logMDCContext) {
        logMDCContext.setTraceId(String.valueOf(new SnowflakeGenerator().next()));
        logMDCContext.setSpanId(DEFAULT_SPAN_ID);
        logMDCContext.setParentSpanId(DEFAULT_PARENT_SPAN_ID);
    }

    /**
     * 将context对象放入TTL装饰的ThreadLocal中
     * @param context 日志上下文对象
     */
    private static void setContext(LogMDCContext context){
        local.set(context);
    }

    /**
     * 获取Local中的上下文对象
     * @return
     */
    public static LogMDCContext getContext(){
        LogMDCContext logMDCContext = local.get();
        if(logMDCContext==null){
            return new LogMDCContext();
        }
        return logMDCContext;
    }

}
