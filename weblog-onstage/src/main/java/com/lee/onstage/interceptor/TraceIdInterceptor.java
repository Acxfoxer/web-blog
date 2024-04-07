package com.lee.onstage.interceptor;

import com.lee.onstage.constants.CommonConstant;
import com.lee.onstage.utils.LogMDCContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j
public class TraceIdInterceptor implements HandlerInterceptor {
//    /**
//     * 实现 TransmittableThreadLocal 的beforeExecute,afterExecute接口
//     */
//    static TransmittableThreadLocal<Map<String, String>> ttlMDC = new TransmittableThreadLocal<Map<String, String>>() {
//        /**
//         * 在多线程数据传递的时候，将数据复制一份给MDC
//         */
//        @Override
//        protected void beforeExecute() {
//            final Map<String, String> mdc = (Map<String, String>) get();
//            mdc.forEach(MDC::put);
//        }
//
//        @Override
//        protected void afterExecute() {
//            MDC.clear();
//        }
//    };
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //如果有上层调用就用上层的ID
        String objectJson = request.getHeader(CommonConstant.LOG_CONTEXT_KEY);
        if(StringUtils.isBlank(objectJson)){
            LogMDCContext.parseContext(objectJson);
        }
        LogMDCContext.initContext(request);
        MDC.put(CommonConstant.TRACE_ID,LogMDCContext.getContext().getTraceId());
        MDC.put(CommonConstant.SPAN_ID,LogMDCContext.getContext().getSpanId());
        MDC.put(CommonConstant.PARENT_SPAN_ID,LogMDCContext.getContext().getParentSpanId());
        MDC.put(CommonConstant.IP,LogMDCContext.getContext().getIp());
        return true;
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        MDC.clear();
    }
}
