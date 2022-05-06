package com.solutions.examples;
/**
 *
 * tips: 动态规划法
 * 1. S(1) = Math.max(M(0),M(1))
 * 2. S(n) = Math.max(S(n-1), S(n-2)+M(n))
 *
 *
 * @author  <a href="mailto:jackson19910303@gmail.com">Jackson</a>
 *
 * @see <a href="https://leetcode-cn.com/problems/house-robber/">198. 打家劫舍</a>
 * @see <a href="https://leetcode.com/problems/house-robber/">198. House Robber</a>
 */
public class Solution198 {
    public int rob(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        int[] total = new int[nums.length];
        total[0] = nums[0];
        total[1] = Math.max(nums[0], nums[1]); // 技巧点1：初始化时，取0和1中较大值作为1的值

        for (int i=2;i<nums.length;i++) {
            total[i] = Math.max(total[i-1], total[i-2]+nums[i]); // 技巧点2：递推公式，取前一个值和当前值+(i-2)中的较大值
        }
        return total[nums.length-1];
    }
}
