package com.lee.onstage.strategy.impl;

import com.lee.onstage.constants.PayManufacturersConstants;
import com.lee.onstage.strategy.PayService;
import org.springframework.stereotype.Service;

@Service(PayManufacturersConstants.PAYPAL_PAY)
public class PayPalPayServiceImpl implements PayService {
    @Override
    public void pay() {
        System.out.println("paypal pay");
    }
}
