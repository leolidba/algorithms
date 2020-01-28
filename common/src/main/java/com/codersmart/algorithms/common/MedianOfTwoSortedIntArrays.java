package com.codersmart.algorithms.common;

import javax.print.attribute.standard.MediaSizeName;

/**
 * O(m + n)
 */
public class MedianOfTwoSortedIntArrays {
    public static void main(String[] args){

        int[] a = {2,4,6,7};
        int[] b = {4,8};
        System.out.println(new MedianOfTwoSortedIntArrays().findMedian(a, b));
    }
    public double findMedian(int[] sortedA, int[] sortedB) {
        double result = 0;

        int sizeA = sortedA.length;
        int sizeB = sortedB.length;

        if(sortedA.length == 0 && sortedB.length == 1) return sortedB[0];
        if(sortedA.length == 1 && sortedB.length == 0) return sortedA[0];

        int i = 0;
        int j = 0;
        int index0 = 0;
        int index1 = 0;

        if((sizeA + sizeB)%2 == 0){
            index0 = (sizeA + sizeB)/2 - 1;
            index1 = index0 + 1;
        }else{
            index0 = (sizeA + sizeB)/2;
            index1 = index0;
        }

        boolean done = false;
        int counter = -1;
        int value = 0;
        while(!done){
            if(i < sizeA &&
                (j < sizeB && sortedA[i] < sortedB[j] || j == sizeB )
            ){
                counter ++;
                value = sortedA[i];
                i++;
            }else if(j < sizeB &&
                    (i < sizeA &&  sortedA[i] >= sortedB[j] || i == sizeA )
            ){
                counter ++;
                value = sortedB[j];
                j++;
            }

            if(counter == index0){
                result = value;
            }
            if(counter == index1){
                result = (result + value)/2.0;
                done = true;
            }

        }

        return result;
    }
}
