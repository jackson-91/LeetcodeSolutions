package com.solutions.examples;

/**
 *
 * tips: 动态规划法
 * S(n) = Math.min(S(n-2)+C(n-2), S(n-1)+C(n-1))
 * S(n-2) = S(n-1)
 * S(n-1) = S(n)
 * S(n)表示爬到第n阶楼梯所花费的体力
 *
 * @author  <a href="mailto:jackson19910303@gmail.com">Jackson</a>
 *
 * @see <a href="https://leetcode-cn.com/problems/min-cost-climbing-stairs/">746. 使用最小花费爬楼梯</a>
 * @see <a href="https://leetcode.com/problems/min-cost-climbing-stairs/">746. Min Cost Climbing Stairs</a>
 */
public class Solution746 {
    public int minCostClimbingStairs(int[] cost) {

        if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }

        int totalStairCost_i = 0;
        int totalStairCost_i_1 = 0;
        int totalStairCost_i_2 = 0;

        for (int i=2; i<=cost.length; i++) {
            totalStairCost_i = Math.min((totalStairCost_i_2+cost[i-2]), (cost[i-1]+totalStairCost_i_1));
            totalStairCost_i_2 = totalStairCost_i_1;
            totalStairCost_i_1 = totalStairCost_i;
        }

        return totalStairCost_i;

    }
}
