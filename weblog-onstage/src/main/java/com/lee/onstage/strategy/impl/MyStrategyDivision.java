package com.lee.onstage.strategy.impl;

import com.lee.onstage.strategy.MyStrategy;

public class MyStrategyDivision implements MyStrategy {
    @Override
    public int doOper(int a, int b) {
        return a!=0&&b!=0?a/b:-1;
    }
}
