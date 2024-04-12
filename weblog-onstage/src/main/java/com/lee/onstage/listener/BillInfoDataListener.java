package com.lee.onstage.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.lee.onstage.entity.BillInfo;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class BillInfoDataListener extends AnalysisEventListener<BillInfo> {
    private List<String> allBillNums =new ArrayList<>();
    @Override
    public void invoke(BillInfo billInfo, AnalysisContext analysisContext) {
        String s = billInfo.getBillNum();
        s="(1,'"+s+"')";
        allBillNums.add(s);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.info(allBillNums.toString());
    }
}
