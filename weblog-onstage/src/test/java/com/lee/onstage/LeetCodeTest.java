package com.lee.onstage;

import java.util.PriorityQueue;

public class LeetCodeTest {
    public static void main(String[] args) {
        int[] nums = new int[]{3,4,5,1,6,7};
        int[] ints = numsGame(nums);
        for (int num : ints) {
            System.out.println(num);
        }

    }

    /**
     * LeetCode LCP 24. 数字游戏
     * 记录给定数组中0~i变为递增序列所需的操作次数,每次操作可选择将数组中数字减一加一
     * 例如[3,4,5,1,6,7]==》[3,4,5,6,7,8]对应的操作数和为[0,0,0,5,6,7]
     * 解题思路:中位数贪心,加对顶队列
     * 以例子为例,假设[3,4,5,1,6,7]的第一位为a0,值为x,则符合题意的结果为
     * [a0,a1,a2,a3,a4,a5]===》[x,x+1,x+2,x+3,x+4,x+5]
     *  则对应的最小操作数和为
     *  |a0-x|+|a1-x-1|+|a2-x-2|+|a3-x-3|+|a4-x-4|+|a5-x-5| 取最小值
     *  即ai-i-x 为0~i的操作册数
     *
     *  设fi = ai-i
     *  则对应的操作数和如下
     *  f(y)=|f0-x|+|f1-x|+|f2-x|+|f3-x|+|f4-x|+······+|fn-x| 取最小值
     *  因此求最小操作数和则等同于求把fi中所有数变为同一个数的最少变化次数
     *
     *  仍以上诉例子为例[3,4,5,1,6,7]对应的fi数组如下
     *
     *  [3,3,3,-2,2,2]
     *  将上述数组变为同一个整数的操作次数则为最小操作数
     *
     *  现在求fi对应的所有0-i的最小操作数和
     *  结合前面推理,将fi中元素变为中位数最优。
     *  则考虑最小变化次数即是中位数右侧和减去中位数左侧和
     *  当fi长度为偶数时 中位数为fn/2
     *  以n=8为例则最小操作数和 =f4+f5+f6+f7-f4-f3-f2-f1
     *  fi长度为奇数时,中位数为f(n-1)/2
     *  其最小操作数和为去掉中位数后,右减左
     *  以n=7为例
     *  最小操作数和为=f6+f5+f4-f2-f1-f0
     *
     *  因此对此题可以按照
     *
     *  对顶堆维护动态中位数
     *  left维护左半之和
     *  right维护右半之和,right栈顶
     *
     *
     *  对应如下
     *  [0,0,0,5,6,7]
     * 默认队列递增
     * @param nums
     * @return
     */
    public static  int[] numsGame(int[] nums){
        //考虑结果很大,对10000007取模
        final int MOD = 10000007;
        //指定值小的优先级高,跟顶为大根(大值)维护数组中位数左边较小一半值,似递增序列
        PriorityQueue<Integer> left = new PriorityQueue<>((a,b)->b-a);
        //默认小根堆,(堆顶优先级最高的为较小值,似递减序列)维护数组中右边较大一半值
        PriorityQueue<Integer> right = new PriorityQueue<>();
        int n = nums.length;
        int[] res = new int[n];
        //左边数和
        long leftSum=0;
        //右边数和
        long rightSum=0;
        for (int i = 0; i < nums.length; i++) {
            int b = nums[i]-i;
            //判断i的奇偶
            if(i%2==1){
                //0~i长度为偶数,判断当前数是否大于right小根堆堆顶元素,大于则需要入列right
                if(b>right.peek()){
                    //大于堆顶,此时rightSum值为原来的rightSum加上新入列的b值跟原堆顶值差值的和
                    rightSum+=b-right.peek();
                    //b进入right队列
                    right.offer(b);
                    //b则为right新弹出的堆顶元素
                    b=right.poll();
                }
                //b此时恒小于维护的right队列,则入列left,leftSum则等于原leftSum+b
                leftSum+=b;
                left.offer(b);
                res[i]= (int) ((rightSum-leftSum)%MOD);
            }else {
                //0~i长度为奇数,right堆顶为中位数,判断当前数是否小于left堆顶数
                if(!left.isEmpty()&&b<left.peek()){
                    //小于则当前左边和等于之前左边和减去left堆顶跟新入列b的差制
                    leftSum-=left.peek()-b;
                    left.offer(b);
                    //此时b值为left弹出的堆顶值
                    b=left.poll();
                }
                //右边和加上弹出的left堆顶,或本身b大于left堆顶
                rightSum+=b;
                //b入列right
                right.offer(b);
                //[3,3,3,-2,2,2]
                res[i]= (int) ((rightSum-right.peek()-leftSum)%MOD);
            }
        }
        return  res;
    }
}
