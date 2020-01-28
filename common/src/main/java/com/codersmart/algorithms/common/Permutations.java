package com.codersmart.algorithms.common;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Permutations {
    public static void main(String[] args){
        int[]data = {1, 2, 3};
        System.out.println(new Permutations().permute(data));
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new LinkedList<>();
        List<Integer> working = new LinkedList<>();
        getAllPermutations(results, working, nums);
        return results;
    }

    private void getAllPermutations(List<List<Integer>> results, List<Integer> working, int[] nums) {
        if(working.size() == nums.length){
            results.add(working);
            return;
        }
        if(working.size() < nums.length){
            for(int num: nums){
                if(!working.contains(num)) {
                    List<Integer> newWorking = new LinkedList<>(working);
                    newWorking.add(num);
                    getAllPermutations(results, newWorking, nums);
                }
            }
        }
    }
}
