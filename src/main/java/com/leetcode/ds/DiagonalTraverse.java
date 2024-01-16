package com.leetcode.ds;

import java.util.*;

public class DiagonalTraverse {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer,List<Integer>> diagonal = new HashMap<>();
        int numElements = 0;

        for(int i=0; i<nums.size(); i++ ){
            List<Integer> row = nums.get(i);
            for(int j=0; row!=null && j<row.size();j++){
                int cell = row.get(j);
                if(!diagonal.containsKey(i+j)){
                    diagonal.put(i+j, new Vector<>());
                }
                diagonal.get(i+j).add(cell);
                numElements++;
            }
        }
        int[] res = new int[numElements];
        int res_ptr=0;
        for(int i=0;diagonal.containsKey(i);i++){
            List<Integer> row = diagonal.get(i);
            for(int j=row.size()-1; j>=0 ;j--){
                res[res_ptr++] = row.get(j);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //List<List<Integer>> nums = Arrays.asList(Arrays.asList(1,2,3), Arrays.asList(4,5,6), Arrays.asList(7,8,9));
        List<List<Integer>> nums = Arrays.asList(Arrays.asList(1,2,3,4,5), Arrays.asList(6,7), Arrays.asList(8), Arrays.asList(9,10,11), Arrays.asList(12,13,14,15,16));
        DiagonalTraverse obj = new DiagonalTraverse();
        int[] result = obj.findDiagonalOrder(nums);
        for(int i=0; i<result.length;i++)
            System.out.print(result[i]+"\t");
    }
}
