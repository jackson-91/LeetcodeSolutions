package com.solutions.examples;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * tips:
 * 1. 将 输入数num 切分成 位数digit 存入位数组中
 * 2. 若输入数大于0，则将位数组从小往大排序；若输入数小于0，则将位数组从大往小排序
 * 3. 若排序后首位是0，则选择最小的不为0的数设为首位
 * 4. 重新构造新的输出数
 *
 * @author  <a href="mailto:jackson19910303@gmail.com">Jackson</a>
 *
 * @see <a href="https://leetcode-cn.com/problems/smallest-value-of-the-rearranged-number/">2165. 重排数字的最小值</a>
 * @see <a href="https://leetcode.com/problems/smallest-value-of-the-rearranged-number/">2165. Smallest Value of the Rearranged Number</a>
 *
 */
public class Solution2165 {

    public long smallestNumber(long num) {
        boolean minusFlag = false;
        if (num < 0) {
            minusFlag = true;
            num = num * (-1);
        }

        // 将 输入数num 切分成 位数digit 存入位数组中
        List<Integer> numList = new ArrayList<>();
        for (long i=1;i<=num;i=i*10) {
            Integer tmp = Long.valueOf(num%(i*10)/i).intValue();
            numList.add(java.lang.Math.abs(tmp));
        }

        // 若输入数大于0，则将位数组从小往大排序；若输入数小于0，则将位数组从大往小排序
        if (minusFlag == false) {
            numList.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1-o2;
                }
            });
        } else {
            numList.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2-o1;
                }
            });
        }

        // 若排序后首位是0，则选择最小的不为0的数设为首位
        if (numList.size() > 0 && Integer.valueOf(0).equals(numList.get(0))) {
            Integer l;
            for (int i = 0; i<=numList.size()-1; i++) {
                l = numList.get(i);
                if (!l.equals(0)) {
                    numList.set(i, 0);
                    numList.set(0, l);
                    break;
                }
            }
        }

        // 重新构造新的输出数
        long result = 0L;
        long j = 1L;
        for (int i=numList.size()-1; i>=0; i--) {
            result += j*numList.get(i);
            j = j*10;
        }

        if (minusFlag) {
            result = result * (-1);
        }

        return result;

    }

}
