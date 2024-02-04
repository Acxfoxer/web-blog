package com.lee.onstage;

import java.util.Arrays;

/**
 * 石子游戏test
 */
public class StoneGameTest {
    public static void main(String[] args) {
        int[] aliceValues=new int[]{2,4,3};
        int[] bobValues=new int[]{1,6,7};
        System.out.println(stoneGame(aliceValues,bobValues));

    }

    public static int stoneGame(int[] a, int[] b) {
        /**
         * alice先选,不光考虑自己最大,还尽量要让bob拿到小的
         * 假设alice拿到i,bob拿到j
         * alice只需要考虑 a[i]-b[j]>0
         * 如果alice拿到j更优
         * 则a[j]-b[i]>a[i]-b[j]
         * 则演变成a[j]+b[j]>a[i]+b[i]
         * 因此思路先将两个数组加在一起按从小到大排序
         * a[i]+b[i] 为b值 ,a[j]+b[j]为A值
         *
         */
        int n = a.length;
        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; i++) {
            ids[i]=i;
        }
        //维护数组ids,记录A-B的值从小到大的索引,此时A跟B最优的都是从左到右依次选择
        Arrays.sort(ids,(i,j)-> a[j]+b[j]-a[i]-b[i]);
        //表示A-B的差值
        int diff = 0;
        for (int i = 0; i < ids.length; i++) {
            //i为偶数则默认为Alice的最优选,为奇数位Bob的最优选
            //偶数加上Alice的分数,奇数减去Bob的分数
            diff+=i%2==0?a[ids[i]]:-b[ids[i]];
        }
        return Integer.compare(diff, 0);
    }


    /**
     * Alice 先拿
     * bob 后拿
     * 每个人可以先拿1-3个
     * @param n
     *  1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
     *  a a a b a a a b a a  a
     * @return
     */
    public static boolean canWinNim(int n){
        return  n%4!=0;
    }
}
