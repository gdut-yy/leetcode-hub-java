import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2831 {
    private static final int MX = (int) (1e5 + 1);

    public int longestEqualSubarray(List<Integer> nums, int k) {
        int n = nums.size();

        int left = 1;
        int right = n + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (!checkMid(nums, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }

    private boolean checkMid(List<Integer> nums, int k, int mid) {
        // 窗口大小
        int sz = Math.min(nums.size(), k + mid);
        int[] cnt = new int[MX];
        for (int i = 0; i < sz; i++) {
            Integer x = nums.get(i);
            cnt[x]++;
            if (cnt[x] >= mid) return true;
        }
        for (int i = sz; i < nums.size(); i++) {
            Integer add = nums.get(i);
            Integer rm = nums.get(i - sz);
            cnt[add]++;
            cnt[rm]--;
            if (cnt[add] >= mid) return true;
        }
        return false;
    }

    // 时间复杂度 O(n)
    public int longestEqualSubarray2(List<Integer> nums, int k) {
        int n = nums.size();
        Map<Integer, List<Integer>> posMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = nums.get(i);
            // ps[i]-i
            List<Integer> xList = posMap.getOrDefault(x, new ArrayList<>());
            xList.add(i - xList.size());
            posMap.put(x, xList);
        }

        int ans = 0;
        for (List<Integer> ps : posMap.values()) {
            int left = 0;
            for (int right = 0; right < ps.size(); right++) {
                // while p[r]-p[l]+1 - (r-l+1) > k
                // 移项 p[r]-p[l]-r+l = p[r]-r - (p[l]-l]
                while (ps.get(right) - ps.get(left) > k) {
                    left++;
                }
                ans = Math.max(ans, right - left + 1);
            }
        }
        return ans;
    }

    // 时间复杂度 O(n)
    public int longestEqualSubarray3(List<Integer> nums, int k) {
        int n = nums.size();
        Map<Integer, List<Integer>> posMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            posMap.computeIfAbsent(nums.get(i), key -> new ArrayList<>()).add(i);
        }

        int ans = 0;
        for (List<Integer> ps : posMap.values()) {
            int l = 0, r = 0;
            while (r < ps.size()) {
                while (ps.get(r) - ps.get(l) + 1 - (r - l + 1) > k) {
                    l++;
                }
                ans = Math.max(ans, r - l + 1);
                r++;
            }
        }
        return ans;
    }
}
/*
2831. 找出最长等值子数组
https://leetcode.cn/problems/find-the-longest-equal-subarray/

第 359 场周赛 T4。

给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
如果子数组中所有元素都相等，则认为子数组是一个 等值子数组 。注意，空数组是 等值子数组 。
从 nums 中删除最多 k 个元素后，返回可能的最长等值子数组的长度。
子数组 是数组中一个连续且可能为空的元素序列。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= nums.length
0 <= k <= nums.length

二分答案 + 滑窗check。赛后发现 O(n) 的滑动窗口解法。
时间复杂度 O(nlogn)
 */