import java.util.ArrayList;
import java.util.List;

public class Solution6186 {
    private static final int MAX_N = 31;

    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;

        int[][] bitCnt = new int[n][MAX_N];
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < MAX_N; k++) {
                if (((nums[i] >> k) & 1) == 1) {
                    bitCnt[i][k]++;
                }
            }
        }

        int[][] preSum = new int[n + 1][MAX_N];
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < MAX_N; k++) {
                preSum[i + 1][k] = preSum[i][k] + bitCnt[i][k];
            }
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            // [i, n-1] 最大按位或
            int max = 0;
            for (int k = 0; k < MAX_N; k++) {
                if (preSum[n][k] - preSum[i][k] > 0) {
                    max++;
                }
            }

            // 二分
            int left = i;
            int right = n;
            while (left < right) {
                int mid = left + (right - left) / 2;
                // 边界二分 F, F,..., F, [T, T,..., T]
                // ----------------------^
                if (checkMid(preSum, i, max, mid)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            res[i] = left - i + 1;
        }
        return res;
    }

    // FFFTTT
    private boolean checkMid(int[][] preSum, int i, int max, int mid) {
        int cnt = 0;
        for (int k = 0; k < MAX_N; k++) {
            if (preSum[mid + 1][k] - preSum[i][k] > 0) {
                cnt++;
            }
        }
        return cnt == max;
    }

    // 时间复杂度 O(n*logmax(nuns))
    // 空间复杂度 O(logmax(nuns))
    public int[] smallestSubarrays2(int[] nums) {
        int n = nums.length;

        int[] res = new int[n];
        List<int[]> ors = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            int num = nums[i];
            ors.add(new int[]{0, i});
            int k = 0;
            for (int[] or : ors) {
                or[0] |= num;
                if (ors.get(k)[0] == or[0]) {
                    ors.get(k)[1] = or[1];
                } else {
                    k++;
                    ors.set(k, or);
                }
            }
            // https://leetcode.cn/problems/smallest-subarrays-with-maximum-bitwise-or/solution/by-endlesscheng-zai1/1759818
            ors.subList(k + 1, ors.size()).clear();
            res[i] = ors.get(0)[1] - i + 1;
        }
        return res;
    }
}
/*
6186. 按位或最大的最小子数组长度
https://leetcode.cn/problems/smallest-subarrays-with-maximum-bitwise-or/

第 87 场双周赛 T3。

给你一个长度为 n 下标从 0 开始的数组 nums ，数组中所有数字均为非负整数。对于 0 到 n - 1 之间的每一个下标 i ，
你需要找出 nums 中一个 最小 非空子数组，它的起始位置为 i （包含这个位置），同时有 最大 的 按位或运算值 。
- 换言之，令 Bij 表示子数组 nums[i...j] 的按位或运算的结果，你需要找到一个起始位置为 i 的最小子数组，这个子数组的按位或运算的结果等于 max(Bik) ，其中 i <= k <= n - 1 。
一个数组的按位或运算值是这个数组里所有数字按位或运算的结果。
请你返回一个大小为 n 的整数数组 answer，其中 answer[i]是开始位置为 i ，按位或运算结果最大，且 最短 子数组的长度。
子数组 是数组里一段连续非空元素组成的序列。
提示：
n == nums.length
1 <= n <= 10^5
0 <= nums[i] <= 10^9

难点在于需要在时间复杂度 `O(1)` 内知道区间的按位或，比赛时用了前缀和思想 + 二分查找求解。
时间复杂度 O(nlogn) 常数为 logmax(nums) 可看作 30
相似题目: 898. 子数组按位或操作
https://leetcode.cn/problems/bitwise-ors-of-subarrays/
1521. 找到最接近目标值的函数值
https://leetcode.cn/problems/find-a-value-of-a-mysterious-function-closest-to-target/
 */