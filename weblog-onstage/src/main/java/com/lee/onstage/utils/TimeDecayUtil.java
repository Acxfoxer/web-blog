package com.lee.onstage.utils;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 计算热门文章工具类
 */
public class TimeDecayUtil {
    private static double decay = 0.5;
    private static int offset = 3;
    private static int scale =173;
    /**
     * 当前热度分=上一期得分 x exp（-（冷却系数） x 间隔的小时数）
     * 时间缩减计算方法
     * @param createTime 发布日期
     * @return
     */
    private static Double decayExp(Date createTime){
        Date origin = DateUtil.calendar().getTime();
        //偏移量,默认前3天不考虑
        double lamda = Math.log(decay) / scale;
        return Math.exp(lamda * Math.max(0, Math.abs(DateUtil.between(createTime,origin, DateUnit.DAY) - offset)));
    }

    private static Double decayExp(String createTime){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date beginDate;
        try {
            beginDate = sdf.parse(createTime);
            Date origin = DateUtil.calendar().getTime();
            //偏移量,默认前3天不考虑
            double lamda = Math.log(decay) / scale;
            return Math.exp(lamda * Math.max(0, Math.abs(DateUtil.between(beginDate,origin, DateUnit.DAY) - offset)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
