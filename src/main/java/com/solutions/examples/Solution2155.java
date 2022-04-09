package com.solutions.examples;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * tips: <pre>{@code
 *  if (nums[i-1] == 0) {
 *      numLeftScore[i] = numLeftScore[i-1] + 1;
 *      numRightScore[i] = numRightScore[i-1];
 *  } else if (nums[i-1] == 1) {
 *      numLeftScore[i] = numLeftScore[i-1];
 *      if (numRightScore[i-1] > 0) {
 *          numRightScore[i] = numRightScore[i-1] - 1;
 *      }
 *  }
 * }</pre>
 *
 * @author  <a href="mailto:jackson19910303@gmail.com">Jackson</a>
 *
 * @see <a href="https://leetcode-cn.com/problems/all-divisions-with-the-highest-score-of-a-binary-array/">2155. 分组得分最高的所有下标</a>
 * @see <a href="https://leetcode.com/problems/all-divisions-with-the-highest-score-of-a-binary-array/">2155. All Divisions With the Highest Score of a Binary Array</a>
 *
 */
public class Solution2155 {

    public List<Integer> maxScoreIndices(int[] nums) {

        Integer[] numLeftScore = new Integer[nums.length+1];
        Integer[] numRightScore = new Integer[nums.length+1];

        Integer totalLeftScore = 0;
        Integer totalRightScore = 0;

        // 左侧的最高总分='0'的总个数；右侧的最高总分='1'的总个数
        for (Integer i=0; i<nums.length; i++) {
            if (nums[i] == 0) {
                totalLeftScore++;
            } else if (nums[i] == 1) {
                totalRightScore++;
            }
        }

        // 初始化左侧位置的最低分和右侧位置的最高分（所有元素均归右侧）
        numLeftScore[0] = 0;
        numRightScore[0] = totalRightScore;

        // 初始化左侧位置的最高分和右侧位置的最低分（所有元素均归左侧）
        numLeftScore[nums.length] = totalLeftScore;
        numRightScore[nums.length] = 0;

        // 从左向右移动游标
        // 当游标移过的位置为0时，左侧+1分，右侧的分数为前一个位置的分数
        // 当游标移过的位置为1时，左侧的分数为前一个位置的分数，右侧-1分
        for (Integer i=1; i<nums.length; i++) {
            if (nums[i-1] == 0) {
                numLeftScore[i] = numLeftScore[i-1] + 1;
                numRightScore[i] = numRightScore[i-1];
            } else if (nums[i-1] == 1) {
                numLeftScore[i] = numLeftScore[i-1];
                if (numRightScore[i-1] > 0) {
                    numRightScore[i] = numRightScore[i-1] - 1;
                }
            }
        }

        Integer maximumTotalScore = 0;
        List<Integer> maximumList = new ArrayList<>();

        // 左侧对应位置分数和右侧对应位置分数相加，计算最高得分和记录对应位置
        for (Integer i=0; i<nums.length+1; i++) {
            if (numLeftScore[i] + numRightScore[i] > maximumTotalScore) {
                maximumTotalScore = numLeftScore[i] + numRightScore[i];
                maximumList.clear();
                maximumList.add(i);
            } else if (numLeftScore[i] + numRightScore[i] == maximumTotalScore) {
                maximumList.add(i);
            }
        }
        return maximumList;
    }

}
