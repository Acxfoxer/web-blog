package com.lee.onstage.strategy.impl;

import com.lee.onstage.constants.PayManufacturersConstants;
import com.lee.onstage.strategy.PayService;
import org.springframework.stereotype.Service;

@Service(PayManufacturersConstants.ALI_PAY)
public class AliPayServiceImpl implements PayService {
    @Override
    public void pay() {
        System.out.println("支付宝支付");
    }
}
