package com.lee.onstage;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        String ans = "";



    }

    private static void bubSort(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = 0; j < nums.length-1-i; j++) {
                if(nums[j]> nums[j+1]){
                    int temp = nums[j];
                    nums[j]= nums[j+1];
                    nums[j+1]=temp;
                }
            }
            System.out.println(Arrays.toString(nums));
        }
    }
}