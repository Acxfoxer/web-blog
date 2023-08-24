package com.lee.onstage;

import com.lee.onstage.strategy.StrategyContext;
import com.lee.onstage.strategy.impl.MyStrategyAdd;
import com.lee.onstage.strategy.impl.MyStrategyDivision;
import com.lee.onstage.strategy.impl.MyStrategyMultiply;
import com.lee.onstage.strategy.impl.MyStrategySubtract;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = OnStageApplicationTest.class)
public class OnStageApplicationTest {

    @Test
    public void test(){
        StrategyContext context = new StrategyContext(new MyStrategyDivision());
        System.out.println(context.executeStrategy(1,2));
        StrategyContext context1= new StrategyContext(new MyStrategySubtract());
        System.out.println(context1.executeStrategy(1,2));
        StrategyContext context2 = new StrategyContext(new MyStrategyAdd());
        System.out.println(context2.executeStrategy(1,2));
        StrategyContext context3 = new StrategyContext(new MyStrategyMultiply());
        System.out.println(context3.executeStrategy(1,2));
    }
}
