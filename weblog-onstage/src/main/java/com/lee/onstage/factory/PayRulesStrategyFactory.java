package com.lee.onstage.factory;

import com.lee.onstage.strategy.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;

/**
 * 支付规则策略工厂
 * @author  Acxfoxer
 * @date    20240415
 */
@Component
public class PayRulesStrategyFactory {
    @Autowired
    Map<String, PayService> payServiceMap;


    public PayService getPayService(String s) throws Exception{
        PayService payService = payServiceMap.get(s);
        if(Objects.isNull(payService)){
            throw new NullPointerException();
        };
        return payService;
    }
}
