package com.solutions.examples;

/**
 *
 * tips:
 * <pre>
 * 1. 模的交换律，结合律，分配律
 * (a + b) % mod = a % mod + b % mod
 * (a - b) % mod = a % mod - b % mod
 * (a * b) % mod = ((a % mod) * (b % mod)) % mod
 * (a / b) % mod = ((a % mod) / (b % mod)) % mod
 * </pre>
 *
 * <pre>
 * 2. 反向滑窗
 * </pre>
 *
 * @author  <a href="mailto:jackson19910303@gmail.com">Jackson</a>
 *
 * @see <a href="https://leetcode-cn.com/problems/find-substring-with-given-hash-value/">2156. 查找给定哈希值的子串</a>
 * @see <a href="https://leetcode.com/problems/find-substring-with-given-hash-value/">2156. Find Substring With Given Hash Value</a>
 *
 */
public class Solution2156 {

    public static Integer[] modArray;

    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        Long lastCalHashMod = calLastMod(power, modulo, k);
        // 计算首个（从右往左数）字符串的hashValue
        Long stringHashValue = calFirstStringHashValue(s, power, k, modulo);
        String result = "";
        if (stringHashValue.equals(Integer.valueOf(hashValue).longValue())) {
            result = s.substring(s.length()-k);
        }
        // 反向滑窗，从右往左滑窗
        for (int i=s.length()-k-1; i>=0; i--) {
            Long calHashValue = calStringHash(stringHashValue, modulo, power, s.charAt(i+k), s.charAt(i), lastCalHashMod);
            stringHashValue = calHashValue;
            if (calHashValue.equals(Integer.valueOf(hashValue).longValue())) {
                result = s.substring(i, i+k);
            }
        }
        return result;
    }

    /**
     * 初始化：计算从右往左第一个字符串的hash值
     * @param s 字符串
     * @param power 幂
     * @param k 结果字符串总长度
     * @param mod 模
     * @return 从右往左第一个字符串的hash值
     */
    public Long calFirstStringHashValue(String s, Integer power, Integer k, Integer mod) {
        Long hashValue = 0L;
        for (Integer i=s.length()-1;i>=s.length()-k;i--) {
            Integer val = s.charAt(i) - 'a' + 1;
            hashValue = (hashValue * power % mod + val % mod) % mod;
        }
        return hashValue;
    }

    /**
     * 计算最后一个幂的模
     * @param power 幂
     * @param mod 模
     * @param k 结果字符串总长度
     * @return 最后一个幂的模，当k不变时，该值不变
     */
    public Long calLastMod(Integer power, Integer mod, Integer k) {
        Long lastMod = 1L;
        for (Integer i=1; i<k; i++) {
            lastMod = (lastMod * power) % mod;
        }
        return lastMod;
    }

    /**
     *
     * @param hashValue 原字符串hash值
     * @param mod 模
     * @param power 幂
     * @param deleteChar 删除的字符
     * @param insertChar 新增的字符
     * @param lastMod 最后一个幂的模
     * @return 新字符串的hash值
     */
    public Long calStringHash(Long hashValue, Integer mod, Integer power, char deleteChar, char insertChar, Long lastMod) {
        Integer deleteNum = deleteChar - 'a' + 1;
        Integer insertNum = insertChar - 'a' + 1;
        Long deleteMod = (deleteNum * lastMod) % mod;
        // tmpHashValue 为去除最后一个字符后的hashValue
        Long tmpHashValue = (((hashValue + mod - deleteMod) % mod) * power) % mod; // 因为 deleteMod < mod && hashValue < mod，所以 hashValue + mod- deleteMod 保证结果非负
        // newHashValue 是加上左侧一个字符后的hashValue
        Long newHashValue = (tmpHashValue + insertNum) % mod;
        return newHashValue;
    }

}
