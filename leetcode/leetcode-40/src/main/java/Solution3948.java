import java.util.Arrays;

public class Solution3948 {
    public int[] maximumMEX(int[] nums) {
        int n = nums.length;
        int[] freq = new int[n + 2];
        for (int x : nums) {
            if (x <= n + 1) freq[x]++;
        }
        int mex = 0;
        while (freq[mex] > 0) mex++;
        int[] seen = new int[n + 2];
        int tag = 0;
        int[] res = new int[n];
        int ri = 0, i = 0;
        while (i < n) {
            if (mex == 0) {
                while (i < n) { res[ri++] = 0; i++; }
                break;
            }
            tag++;
            int cnt = 0, j = i;
            for (; j < n; j++) {
                int v = nums[j];
                if (v < mex && seen[v] != tag) {
                    seen[v] = tag;
                    if (++cnt == mex) break;
                }
            }
            res[ri++] = mex;
            for (int k = i; k <= j; k++) {
                int v = nums[k];
                if (v <= n + 1) {
                    freq[v]--;
                    if (freq[v] == 0 && v < mex) mex = v;
                }
            }
            i = j + 1;
        }
        return Arrays.copyOf(res, ri);
    }
}
/*
3948. 字典序最大的 MEX 数组
https://leetcode.cn/problems/lexicographically-maximum-mex-array/description/

第 504 场周赛 T4。

给你一个整数数组 nums。
你需要构造一个数组 result，具体做法是重复执行以下操作，直到 nums 变为空：
- 选择一个整数 k，满足 1 <= k <= len(nums)。
- 计算 nums 的前 k 个元素的 MEX。
- 将这个 MEX 附加到 result。
- 从 nums 中移除前 k 个元素。
返回执行这些操作后能得到的 字典序最大 的数组 result。
数组的 MEX 是指数组中不包含的 最小非负 整数。
如果两个数组 a 和 b 在第一个不同的下标处，数组 a 的元素大于数组 b 的对应元素，则数组 a 字典序大于 数组 b。如果前 min(a.length, b.length) 个元素都相同，那么较长的数组是 字典序更大 的数组。
提示：
1 <= nums.length <= 10^5
0 <= nums[i] <= 10^5

分组循环。
时间复杂度 O(n)。
 */