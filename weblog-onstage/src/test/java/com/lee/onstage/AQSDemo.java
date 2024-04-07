package com.lee.onstage;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class AQSDemo extends AbstractQueuedSynchronizer {
    @Override
    protected boolean tryAcquire(int arg) {
        Map map = new HashMap();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,1,0, TimeUnit.SECONDS,
               new LinkedBlockingDeque<>(), Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());
        if(compareAndSetState(0,1)){
            setExclusiveOwnerThread(Thread.currentThread());
            return true;
        }else {
            acquire(1);
        }
        return false;
    }



}
