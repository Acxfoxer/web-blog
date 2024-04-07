package com.lee.onstage;


import com.lee.onstage.utils.LogMDCContext;

public class TestMdc {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            LogMDCContext.initContext();
            System.out.println(LogMDCContext.class.hashCode());
        }
        LogMDCContext context = LogMDCContext.getContext();
        
    }
}
