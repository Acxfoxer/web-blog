package com.lee.onstage.strategy.impl;

import com.lee.onstage.constants.PayManufacturersConstants;
import com.lee.onstage.strategy.PayService;
import org.springframework.stereotype.Service;

@Service(PayManufacturersConstants.WX_PAY)
public class WXPayServiceImpl implements PayService {
    @Override
    public void pay() {
        System.out.println("这是微信支付");
    }
}
