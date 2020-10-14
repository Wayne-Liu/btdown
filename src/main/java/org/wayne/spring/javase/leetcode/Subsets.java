package org.wayne.spring.javase.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        output.add(new ArrayList<Integer>());

        for (int num: nums) {
            List<List<Integer>> newSubsets = new ArrayList<>();
            for (List<Integer> curr: output) {
                ArrayList<Integer> tmp = new ArrayList<>(curr);
                tmp.add(num);
                newSubsets.add(tmp);

                //newSubsets.add(new ArrayList<Integer>(curr){{add(num);}});

            }
            for (List<Integer> curr: newSubsets) {
                output.add(curr);
            }
        }
        return output;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Subsets subsets = new Subsets();
        System.out.println(subsets.subsets(nums));
    }
}
