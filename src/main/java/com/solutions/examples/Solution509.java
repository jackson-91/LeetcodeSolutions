package com.solutions.examples;

/**
 *
 * tips:
 * <pre>
 * {@code
 * for() {
 *     fibb = first + second;
 *     first = second;
 *     second = fibb;
 * }
 * }
 * </pre>
 *
 * @author  <a href="mailto:jackson19910303@gmail.com">Jackson</a>
 *
 * @see <a href="https://leetcode-cn.com/problems/fibonacci-number/">509. 斐波那契数</a>
 * @see <a href="https://leetcode.com/problems/fibonacci-number/">509. Fibonacci Number</a>
 *
 */
public class Solution509 {

    public int fib(int n) {
        int fibb = 0;
        int first = 0;
        int second = 0;

        if (n>=1) {
            second = 1;
            fibb = first + second;
        }
        for (int i=2; i<=n; i++) {
            fibb = first + second;
            first = second;
            second = fibb;
        }
        return fibb;
    }

}
