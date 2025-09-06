import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution3605 {
    // 200ms
    static class V1 {
        private int[][] st;
        private int[] log;
        private int n;

        public int minStable(int[] nums, int maxC) {
            n = nums.length;
            if (n == 0) return 0;
            buildSparseTable(nums);
            precomputeLogs();

            int low = 0, high = n;
            while (low <= high) {
                int mid = (low + high) >> 1;
                if (check(mid, maxC, nums)) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }

        private boolean check(int k, int maxC, int[] nums) {
            if (k == 0) {
                int count = 0;
                for (int num : nums) {
                    if (num >= 2) count++;
                }
                return count <= maxC;
            }
            int L = k + 1;
            if (L > n) {
                return true;
            }
            List<int[]> intervals = new ArrayList<>();
            for (int i = 0; i <= n - L; i++) {
                int g = queryGCD(i, i + L - 1);
                if (g >= 2) {
                    intervals.add(new int[]{i, i + L - 1});
                }
            }
            if (intervals.isEmpty()) {
                return true;
            }
            intervals.sort(Comparator.comparingInt(a -> a[1]));
            int points = 0;
            int last = -1;
            for (int[] interval : intervals) {
                int left = interval[0];
                int right = interval[1];
                if (left > last) {
                    points++;
                    last = right;
                }
            }
            return points <= maxC;
        }

        private void buildSparseTable(int[] nums) {
            int k = (int) (Math.log(n) / Math.log(2)) + 1;
            st = new int[k][n];
            System.arraycopy(nums, 0, st[0], 0, n);
            for (int j = 1; j < k; j++) {
                int step = 1 << (j - 1);
                for (int i = 0; i + (1 << j) <= n; i++) {
                    st[j][i] = gcd(st[j - 1][i], st[j - 1][i + step]);
                }
            }
        }

        private void precomputeLogs() {
            log = new int[n + 1];
            log[1] = 0;
            for (int i = 2; i <= n; i++) {
                log[i] = log[i / 2] + 1;
            }
        }

        private int queryGCD(int l, int r) {
            int len = r - l + 1;
            int j = log[len];
            return gcd(st[j][l], st[j][r - (1 << j) + 1]);
        }

        private int gcd(int a, int b) {
            if (b == 0) return a;
            return gcd(b, a % b);
        }
    }

    // 144ms
    static class V2 {
        public int minStable(int[] nums, int maxC) {
            int left = 0;
            int right = nums.length / (maxC + 1);
            while (left < right) {
                int mid = left + (right - left) / 2;
                // 边界二分 F, F,..., F, [T, T,..., T]
                // ----------------------^
                if (check(nums, maxC, mid)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        private boolean check(int[] nums, int maxC, int upper) {
            List<int[]> intervals = new ArrayList<>(); // 每个元素是 (子数组 GCD，最小左端点)
            for (int i = 0; i < nums.length; i++) {
                int x = nums[i];

                // 计算以 i 为右端点的子数组 GCD
                for (int[] interval : intervals) {
                    interval[0] = getGCD(interval[0], x);
                }
                // nums[i] 单独一个数作为子数组
                intervals.add(new int[]{x, i});

                // 去重（合并 GCD 相同的区间）
                int idx = 1;
                for (int j = 1; j < intervals.size(); j++) {
                    if (intervals.get(j)[0] != intervals.get(j - 1)[0]) {
                        intervals.set(idx, intervals.get(j));
                        idx++;
                    }
                }
                intervals.subList(idx, intervals.size()).clear();

                // intervals 的性质：越靠左，GCD 越小

                // 我们只关心 GCD >= 2 的子数组
                if (intervals.get(0)[0] == 1) {
                    intervals.remove(0);
                }

                // intervals[0] 的 GCD >= 2 且最长，取其区间左端点作为子数组的最小左端点
                if (!intervals.isEmpty() && i - intervals.get(0)[1] + 1 > upper) {
                    if (maxC == 0) {
                        return false;
                    }
                    maxC--;
                    intervals.clear(); // 修改后 GCD 均为 1，直接清空
                }
            }
            return true;
        }

        private int getGCD(int num1, int num2) {
            return num1 == 0 ? num2 : getGCD(num2 % num1, num1);
        }
    }
}
/*
3605. 数组的最小稳定性因子
https://leetcode.cn/problems/minimum-stability-factor-of-array/description/

第 160 场双周赛 T4。

给你一个整数数组 nums 和一个整数 maxC。
如果一个 子数组 的所有元素的最大公因数（简称 HCF） 大于或等于 2，则称该子数组是稳定的。
一个数组的 稳定性因子 定义为其 最长 稳定子数组的长度。
你 最多 可以修改数组中的 maxC 个元素为任意整数。
在最多 maxC 次修改后，返回数组的 最小 可能稳定性因子。如果没有稳定的子数组，则返回 0。
注意:
- 子数组 是数组中连续的元素序列。
- 数组的 最大公因数（HCF）是能同时整除数组中所有元素的最大整数。
- 如果长度为 1 的 子数组 中唯一元素大于等于 2，那么它是稳定的，因为 HCF([x]) = x。
提示:
1 <= n == nums.length <= 10^5
1 <= nums[i] <= 10^9
0 <= maxC <= n

二分答案 + ST 表。
时间复杂度 O(nlogn)。
https://chat.deepseek.com/a/chat/s/ac7465ca-a7c9-4ecf-b834-6522a4c472f5
二分答案 + LogTrick / 栈 + 滑动窗口 https://leetcode.cn/problems/minimum-stability-factor-of-array/solutions/3716266/er-fen-da-an-logtrickpythonjavacgo-by-en-jqxy/
时间复杂度 O(nlogU + nlogM)。
rating 2434 (clist.by)
 */