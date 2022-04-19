package com.solutions.examples;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * tips:
 * 1. 当剩余元素<需要元素时，直接返回list
 * 2. 当剩余元素=需要元素时，将剩余元素全部添加到list中，返回list
 * 3. 当剩余元素>需要元素时，先添加开始元素，然后从开始元素+1继续遍历
 *
 * @author  <a href="mailto:jackson19910303@gmail.com">Jackson</a>
 *
 * @see <a href="https://leetcode-cn.com/problems/combinations/">77. 组合</a>
 * @see <a href="https://leetcode.com/problems/combinations/">77. Combinations</a>
 *
 */
public class Solution77 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        getCompositeList(n, k, result);
        return result;

    }

    public void getCompositeList(int n, int k, List<List<Integer>> result) {
        for (int i=1; i<=n; i++) {
            getList(i,n,k,new ArrayList<Integer>(), result);
        }
    }

    public List<Integer> getList(int start, int end, int k, List<Integer> list, List<List<Integer>> result) {
        if ((end-start+1 < k-list.size())) { // 当剩余元素<需要元素时，直接返回list
            return list;
        } else if (end-start+1 == k-list.size()) { // 当剩余元素=需要元素时，将剩余元素全部添加到list中，返回list
            List<Integer> resultList = new ArrayList<>(list);
            for (int i=start;i<=end;i++) {
                resultList.add(i);
            }
            result.add(resultList);
            return list;
        } else if (end-start+1 > k-list.size()) { // 当剩余元素>需要元素时，先添加开始元素，然后从开始元素+1继续遍历
            int size = list.size();
            list.add(start); // 先添加开始元素
            if (list.size() == k) { // 添加后若已满，则直接返回
                List<Integer> resultList = new ArrayList<>(list);
                result.add(resultList);
                list.remove(k-1);
                return list;
            }
            for (int i=start+1;i<=end;i++) { // 从开始元素+1继续遍历
                list = getList(i,end,k,list,result);
            }
            list.remove(size);
        }
        return list;
    }

}
