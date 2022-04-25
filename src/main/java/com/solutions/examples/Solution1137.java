package com.solutions.examples;

/**
 *
 * tips:
 * <pre>
 * {@code
 * for (int i=3;i<=n;i++) {
 *      result = tmp[0] + tmp[1] + tmp[2];
 *      tmp[0] = tmp[1];
 *      tmp[1] = tmp[2];
 *      tmp[2] = result;
 * }
 * }
 * </pre>
 *
 * @author  <a href="mailto:jackson19910303@gmail.com">Jackson</a>
 *
 * @see <a href="https://leetcode-cn.com/problems/n-th-tribonacci-number/">1137. 第 N 个泰波那契数</a>
 * @see <a href="https://leetcode.com/problems/n-th-tribonacci-number/">1137. N-th Tribonacci Number</a>
 *
 */
public class Solution1137 {

    public int tribonacci(int n) {
        int[] tmp = new int[3];
        
        int result = tmp[0];
        if (n >= 1) {
            tmp[1] = 1;
            result = tmp[1];
        }
        if (n >= 2) {
            tmp[2] = tmp[0] + tmp[1];
            result = tmp[2];
        }

        for (int i=3;i<=n;i++) {
            result = tmp[0] + tmp[1] + tmp[2];
            tmp[0] = tmp[1];
            tmp[1] = tmp[2];
            tmp[2] = result;
        }
        return result;
    }

}
