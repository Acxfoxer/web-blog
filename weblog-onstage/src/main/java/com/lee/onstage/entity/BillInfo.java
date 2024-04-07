package com.lee.onstage.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class BillInfo {
    @ExcelProperty(index = 3)
    private String billNum;
}
