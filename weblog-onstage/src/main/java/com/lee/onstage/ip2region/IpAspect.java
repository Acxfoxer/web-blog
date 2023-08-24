package com.lee.onstage.ip2region;

import com.lee.onstage.utils.AddressUtil;
import com.lee.onstage.utils.HttpContextUtil;
import com.lee.onstage.utils.IPUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@Slf4j
public class IpAspect {
    private final Logger logger = LoggerFactory.getLogger(IpAspect.class);

    @Pointcut("@annotation(com.lee.onstage.ip2region.Ip)")
    public void pointcut() {
        logger.info("进入切面");
    }

    @Around("pointcut()")
    public Object doAround(ProceedingJoinPoint point) throws  Throwable{
        HttpServletRequest request = HttpContextUtil.getHttpServletRequest();
        String ip = IPUtil.getIpAddr(request);
        String address = AddressUtil.getCityInfo(ip);
        logger.info("当前ip为:[{}],当前IP地址解析出来的地址为:[{}]",ip,address);
        logger.info("当前ip为:"+ip+",当前IP地址解析出来的地址为:[{}]"+address);
        return point.proceed();
    }
}
