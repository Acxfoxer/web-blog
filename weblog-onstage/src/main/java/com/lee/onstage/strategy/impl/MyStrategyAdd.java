package com.lee.onstage.strategy.impl;

import com.lee.onstage.strategy.MyStrategy;

public class MyStrategyAdd implements MyStrategy {
    @Override
    public int doOper(int a, int b) {
        return a+b;
    }
}
