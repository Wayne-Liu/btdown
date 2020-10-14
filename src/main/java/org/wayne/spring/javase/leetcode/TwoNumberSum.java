package org.wayne.spring.javase.leetcode;

import java.util.Arrays;
//两数之和

public class TwoNumberSum {

    public int[] twoSum(int[] nums, int target) {
        if (nums.length <2) {
            return new int[]{};
        }

        //对数据排序
        //Arrays.sort(nums);
        //
        for (int i=0;i<nums.length;i++) {
            for (int j=i+1;j<nums.length;j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i,j};
                }
            }
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = new int[] {3,2,4};
        TwoNumberSum sum = new TwoNumberSum();
        int[] result = sum.twoSum(nums, 6);
        if (result.length >0) {
            System.out.println(result[0]+ ","+result[1]);
        }
    }


}
