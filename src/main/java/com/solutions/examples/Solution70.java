package com.solutions.examples;

/**
 *
 * tips: 动态规划法
 * S(n) = S(n-1)+S(n-2)
 *
 * @author  <a href="mailto:jackson19910303@gmail.com">Jackson</a>
 *
 * @see <a href="https://leetcode-cn.com/problems/climbing-stairs/">70. 爬楼梯</a>
 * @see <a href="https://leetcode.com/problems/climbing-stairs/">70. Climbing Stairs</a>
 */
public class Solution70 {

    public int climbStairs(int n) {
        int oneLeft = 1;
        int twoLeft = 1;
        int result = 0;
        if (n < 2) {
            result = oneLeft;
            return result;
        }
        for (int i=2;i<=n;i++) {
            result = oneLeft + twoLeft;
            twoLeft = oneLeft;
            oneLeft = result;
        }
        return result;
    }

}
