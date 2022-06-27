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
https://leetcode.cn/problems/next-greater-element-i/

nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。
给你两个 没有重复元素 的数组 nums1 和 nums2 ，下标从 0 开始计数，其中nums1 是 nums2 的子集。
对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，并且在 nums2 确定 nums2[j] 的 下一个更大元素 。
如果不存在下一个更大元素，那么本次查询的答案是 -1 。
返回一个长度为 nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。
提示：
1 <= nums1.length <= nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 10^4
nums1和nums2中所有整数 互不相同
nums1 中的所有整数同样出现在 nums2 中
进阶：你可以设计一个时间复杂度为 O(nums1.length + nums2.length) 的解决方案吗？

单调栈模板题。
将 nums1 看作查询数组。先求出 nums2 各个值的结果，存放在 HashMap 中，时间复杂度 O(n)
然后遍历 nums1 得到结果，时间复杂度 O(n)
 */