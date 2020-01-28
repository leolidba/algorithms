package com.codersmart.algorithms.common;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;

import javax.swing.text.Utilities;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CombinationSum {
    public static void main(String[] args){
        int[] data = {2,3,6,7};
        int target = 7;
        System.out.println(new CombinationSum().combinationSum(data, target));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new LinkedList<>();
        List<Integer> working = new LinkedList<>();
        Arrays.sort(candidates);
        DFS(results, working, candidates, 0, target);
        return results;
    }

    private void DFS(List<List<Integer>> results, List<Integer> working, int[] candidates, int pos, int target) {
        int sum = 0;
        for(int num : working){ sum+= num;};
        if(sum == target){
            results.add(new LinkedList<>(working));
            return;
        }
        if(sum > target) return;
        if(sum < target){
            for(int i = pos; i < candidates.length; i++){
                if(target - candidates[i] < 0) break;
                List<Integer> newWorking = new LinkedList<>(working);
                newWorking.add(candidates[i]);
                DFS(results, newWorking, candidates, i, target);
            }
        }

    }

}
