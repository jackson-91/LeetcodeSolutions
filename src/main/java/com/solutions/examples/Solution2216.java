package com.solutions.examples;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * tips: 当结果数组的size是偶数时（需要加进来的是奇数位），判断下一个数字是否与最后一个数字相同；当结果数组的size是奇数时，直接添加（需要加进来的是偶数位）
 *
 * @author  <a href="mailto:jackson19910303@gmail.com">Jackson</a>
 *
 * @see <a href="https://leetcode-cn.com/problems/minimum-deletions-to-make-array-beautiful/">2216. 美化数组的最少删除数</a>
 * @see <a href="https://leetcode.com/problems/minimum-deletions-to-make-array-beautiful/">2216. Minimum Deletions to Make Array Beautiful</a>
 */
public class Solution2216 {

    public int minDeletion(int[] nums) {
        int count = 0;
        List<Integer> result = new ArrayList<>();

        for (int i=0;i<nums.length;i++) {
            if (result.size() == 0) {
                result.add(nums[i]);
                continue;
            }
            if ((result.size()-1)%2!=0) {
                result.add(nums[i]);
            } else {
                if (!result.get(result.size()-1).equals(nums[i])) {
                    result.add(nums[i]);
                } else {
                    count++;
                    continue;
                }
            }
        }

        if (result.size()%2!=0) {
            count++;
        }

        return count;
    }

}
