package com.leetcode.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArithmeticSubArrays {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> answer = new ArrayList<>();
        int left,right;
        for(int i=0; i< l.length;i++){
            left = l[i];
            right = r[i];
            answer.add(i, true);
            int[] slice = new int[right-left+1];
            int slice_ptr =0;
            for(int j=left; j<=right; j++){
                slice[slice_ptr++] = nums[j];
            }
            Arrays.sort(slice);
            int diff = slice[1]-slice[0];
            for(int a=1,b=a+1;b<=slice.length-1;a++,b++){
                if((slice[b]-slice[a])!=diff){
                    answer.set(i, false);
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
       /* int[] nums = {4,6,5,9,3,7};
        int[] l = {0,0,2};
        int[] r = {2,3,5};*/

        int[] nums = {-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10};
        int[] l = {0,1,6,4,8,7};
        int[] r = {4,4,9,7,9,10};

        ArithmeticSubArrays obj = new ArithmeticSubArrays();
        System.out.println(obj.checkArithmeticSubarrays(nums,l,r));
    }
}
