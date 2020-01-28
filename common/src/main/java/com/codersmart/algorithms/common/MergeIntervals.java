package com.codersmart.algorithms.common;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args){
        int[][] data = {{1,3},{2,6},{8,10},{15,18}};
        int[][] result = new MergeIntervals().merge(data);
        for(int[] row: result){
            System.out.println("[" + row[0] + ", " + row[1] + "]");
        }
    }
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return null;
        Arrays.sort(intervals, (x, y) -> x[0] - y[0]);
        List<int[]> list = new LinkedList<>();
        list.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] <= list.get(list.size() - 1)[1]){
                list.get(list.size() - 1)[1] = Math.max(intervals[i][1], list.get(list.size() - 1)[1]);
            }else{
                list.add(intervals[i]);
            }
        }
        int[][] results = new int[list.size()][2];
        for(int i = 0; i < list.size(); i ++){
            results[i] = list.get(i);
        }
        return results;
    }
}
