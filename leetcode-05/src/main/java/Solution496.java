import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Solution496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 单调栈
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> resMap = new HashMap<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                resMap.put(nums2[i], stack.peek());
            } else {
                resMap.put(nums2[i], -1);
            }
            stack.push(nums2[i]);
        }
        // 遍历 nums1 得到结果
        int len1 = nums1.length;
        int[] res = new int[len1];
        for (int i = 0; i < len1; i++) {
            res[i] = resMap.get(nums1[i]);
        }
        return res;
    }
}
/*
496. 下一个更大元素 I
https://leetcode-cn.com/problems/next-greater-element-i/

单调栈模板题。
将 nums1 看作查询数组。先求出 nums2 各个值的结果，存放在 HashMap 中，时间复杂度 O(n)
然后遍历 nums1 得到结果，时间复杂度 O(n)
 */