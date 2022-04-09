package com.solutions.examples;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author  <a href="mailto:jackson19910303@gmail.com">Jackson</a>
 *
 * @see <a href="https://leetcode-cn.com/problems/keep-multiplying-found-values-by-two/">2154. 将找到的值乘以 2</a>
 * @see <a href="https://leetcode.com/problems/keep-multiplying-found-values-by-two/">2154. Keep Multiplying Found Values by Two</a>
 */
public class Solution2154 {

    public int findFinalValue(int[] nums, int original) {
        Set<Integer> numsSet = new HashSet<>(nums.length);
        for (int i=0; i<nums.length; i++) {
            numsSet.add(nums[i]);
        }
        Integer originalInt = original;
        while (numsSet.remove(originalInt)) {
            originalInt = originalInt * 2;
        }
        return originalInt.intValue();
    }

}
