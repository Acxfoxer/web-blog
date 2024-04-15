package com.lee.onstage.strategy.impl;

import com.lee.onstage.constants.PayManufacturersConstants;
import com.lee.onstage.strategy.PayService;
import org.springframework.stereotype.Service;

@Service(PayManufacturersConstants.UNION_PAY)
public class UnionPayServiceImpl implements PayService {

    @Override
    public void pay() {
        System.out.println("这是银联支付");
    }
}
