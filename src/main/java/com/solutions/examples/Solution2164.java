package com.solutions.examples;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * tips:
 * 1. 将 奇数位 和 偶数位 分别存入两个数组oddList和evenList中
 * 2. 奇数位数组递减排序，偶数位数组递增排序
 * 3. 重组一个新的数组
 *
 * @author  <a href="mailto:jackson19910303@gmail.com">Jackson</a>
 *
 * @see <a href="https://leetcode-cn.com/problems/sort-even-and-odd-indices-independently/">2164. 对奇偶下标分别排序</a>
 * @see <a href="https://leetcode.com/problems/sort-even-and-odd-indices-independently/">2164. Sort Even and Odd Indices Independently</a>
 *
 */
public class Solution2164 {

    public int[] sortEvenOdd(int[] nums) {
        Integer[] oddList = new Integer[nums.length/2];
        Integer[] evenList = new Integer[nums.length/2+(nums.length%2)];

        // 将 奇数位 和 偶数位 分别存入两个数组oddList和evenList中
        for (int i=0; i<nums.length; i++) {
            if (i%2 == 0) {
                evenList[i/2] = nums[i];
            } else {
                oddList[i/2] = nums[i];
            }
        }

        // 奇数位数组递减排序，偶数位数组递增排序
        Arrays.sort(oddList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        Arrays.sort(evenList);

        // 重组一个新的数组
        for (int i=0; i<nums.length; i++) {
            if (i%2 == 0) {
                nums[i] = evenList[i/2];
            } else {
                nums[i] = oddList[i/2];
            }
        }

        return nums;

    }

}
