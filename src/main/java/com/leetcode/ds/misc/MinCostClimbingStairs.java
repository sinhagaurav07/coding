package com.leetcode.ds.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.
 *
 * You can either start from the step with index 0, or the step with index 1.
 *
 * Return the minimum cost to reach the top of the floor.
 *
 *
 *
 * Example 1:
 *
 * Input: cost = [10,15,20]
 * Output: 15
 * Explanation: You will start at index 1.
 * - Pay 15 and climb two steps to reach the top.
 * The total cost is 15.
 * Example 2:
 *
 * Input: cost = [1,100,1,1,1,100,1,1,100,1]
 * Output: 6
 * Explanation: You will start at index 0.
 * - Pay 1 and climb two steps to reach index 2.
 * - Pay 1 and climb two steps to reach index 4.
 * - Pay 1 and climb two steps to reach index 6.
 * - Pay 1 and climb one step to reach index 7.
 * - Pay 1 and climb two steps to reach index 9.
 * - Pay 1 and climb one step to reach the top.
 * The total cost is 6.
 *
 *
 * Constraints:
 *
 * 2 <= cost.length <= 1000
 * 0 <= cost[i] <= 999
 *
 */
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];

        if (cost.length == 1){
            return cost[0];
        }else if(cost.length==2){
            return  Math.min(cost[0],cost[1]);
        }
        dp[0] = cost[0];dp[1] = cost[1];

        for(int i=2; i< cost.length; i++){
            dp[i] = Math.min(dp[i-1], dp[i-2]) + cost[i];
        }

        return Math.min(dp[cost.length-1], dp[cost.length-2]);
    }

    @Test
    public void test1(){
        int[] cost = {10,15,20};
        Assert.assertEquals("Sucess", 15, minCostClimbingStairs(cost));
    }

    @Test
    public void test2(){
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        Assert.assertEquals("Sucess", 6, minCostClimbingStairs(cost));
    }

    @Test
    public void test3(){
        int[] cost = {1,100};
        Assert.assertEquals("Sucess", 1, minCostClimbingStairs(cost));
    }

}