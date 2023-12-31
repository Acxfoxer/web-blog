package com.lee.onstage.strategy;

public class StrategyContext {
    private MyStrategy myStrategy;

    public StrategyContext(MyStrategy myStrategy) {
        this.myStrategy = myStrategy;
    }

    public int executeStrategy(int a, int b){
        return myStrategy.doOper(a,b);
    }
}
