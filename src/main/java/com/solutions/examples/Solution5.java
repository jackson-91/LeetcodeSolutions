package com.solutions.examples;

/**
 *
 * tips: 中心扩展法
 *
 * @author  <a href="mailto:jackson19910303@gmail.com">Jackson</a>
 *
 * @see <a href="https://leetcode-cn.com/problems/longest-palindromic-substring/">5. 最长回文子串</a>
 * @see <a href="https://leetcode.com/problems/longest-palindromic-substring/">5. Longest Palindromic Substring</a>
 */
public class Solution5 {

    public static String longestPalindrome = "";

    public String longestPalindrome(String s) {
        longestPalindrome = "";
        for (Integer position=0; position<=s.length()-1;position++) {
            String oddString = findOddPalindrome(s, position);
            String evenString = findEvenPalindrome(s, position);
            String tmpMaxString = oddString.length() >= evenString.length() ? oddString : evenString;
            longestPalindrome = tmpMaxString.length() > longestPalindrome.length() ? tmpMaxString : longestPalindrome;
        }
        return longestPalindrome;
    }


    /**
     * 中心为一位字符向两边扩展
     * @param s 原始字符串
     * @param position 中心位置
     * @return 由中心位置扩展的最长字符串
     */
    public String findOddPalindrome(String s, Integer position) {
        String tmpOddString = Character.toString(s.charAt(position));
        Integer offset = 0;
        for (;position-offset>=0 && position+offset<=s.length()-1; offset++) {
            if (s.charAt(position-offset) == s.charAt(position+offset)) {
                tmpOddString = s.substring(position-offset, position+offset+1);
            } else {
                break;
            }
        }
        return tmpOddString;


    }

    /**
     * 中心为两位字符向两边扩展
     * @param s 原始字符串
     * @param position 靠左侧的中心位置
     * @return 由中心位置扩展的最长字符串
     */
    public String findEvenPalindrome(String s, Integer position) {
        if (position+1 > s.length()-1) {
            return Character.toString(s.charAt(position));
        }
        if (s.charAt(position) != s.charAt(position+1)) {
            return Character.toString(s.charAt(position));
        }
        String tmpEvenString = s.substring(position, position+2);
        Integer offset = 0;
        for (;position-offset>=0 && position+1+offset<=s.length()-1; offset++) {
            if (s.charAt(position-offset) == s.charAt(position+1+offset)) {
                tmpEvenString = s.substring(position-offset, position+1+offset+1);
            } else {
                break;
            }
        }
        return tmpEvenString;
    }
}
