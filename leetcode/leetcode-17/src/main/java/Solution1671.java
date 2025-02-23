import java.util.ArrayList;
import java.util.List;

public class Solution1671 {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;

        int[] pre = new int[n];
        List<Integer> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int v = nums[i];
            int j = lowerBound(g, v);
            if (j == g.size()) g.add(v);
            else g.set(j, v);
            pre[i] = j + 1;
        }

        int[] suf = new int[n];
        g.clear();
        for (int i = n - 1; i >= 0; i--) {
            int v = nums[i];
            int j = lowerBound(g, v);
            if (j == g.size()) g.add(v);
            else g.set(j, v);
            suf[i] = j + 1;
        }

        // arr.length >= 3 题目保证 nums 删除一些元素后一定能得到山形数组。
        int maxLen = 3;
        for (int i = 0; i < n; i++) {
            if (pre[i] > 1 && suf[i] > 1) {
                maxLen = Math.max(maxLen, pre[i] + suf[i] - 1);
            }
        }
        return n - maxLen;
    }

    private int lowerBound(List<Integer> a, int key) {
        int l = 0, r = a.size();
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a.get(m) >= key) r = m;
            else l = m + 1;
        }
        return l;
    }
}
/*
1671. 得到山形数组的最少删除次数
https://leetcode.cn/problems/minimum-number-of-removals-to-make-mountain-array/

我们定义 arr 是 山形数组 当且仅当它满足：
- arr.length >= 3
- 存在某个下标 i （从 0 开始） 满足 0 < i < arr.length - 1 且：
 - arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 - arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
给你整数数组 nums  ，请你返回将 nums 变成 山形状数组 的  最少 删除次数。
提示：
3 <= nums.length <= 1000
1 <= nums[i] <= 10^9
题目保证 nums 删除一些元素后一定能得到山形数组。

两遍 LIS。
时间复杂度 O(n^2) 可用二分优化至 O(nlogn)
相似题目: 300. 最长递增子序列
https://leetcode.cn/problems/longest-increasing-subsequence/
 */