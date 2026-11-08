import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution4109 {
    private static final long BASE = 911382323L;
    private static final long MOD1 = (long) (1e9 + 7);
    private static final long MOD2 = (long) (1e9 + 9);
    private long[] hash1, hash2, lazy1, lazy2;
    private long[] pow1, pow2;

    public int[] countSuffix(int[] nums, int[] target) {
        int n = nums.length;
        int m = target.length;
        int maxLen = Math.max(n, m) + 2;
        pow1 = new long[maxLen];
        pow2 = new long[maxLen];
        pow1[0] = pow2[0] = 1;
        for (int i = 1; i < maxLen; i++) {
            pow1[i] = pow1[i - 1] * BASE % MOD1;
            pow2[i] = pow2[i - 1] * BASE % MOD2;
        }
        long invBase1 = modPow(BASE, MOD1 - 2, MOD1);
        long invBase2 = modPow(BASE, MOD2 - 2, MOD2);
        long[] invPow1 = new long[maxLen];
        long[] invPow2 = new long[maxLen];
        invPow1[0] = invPow2[0] = 1;
        for (int i = 1; i < maxLen; i++) {
            invPow1[i] = invPow1[i - 1] * invBase1 % MOD1;
            invPow2[i] = invPow2[i - 1] * invBase2 % MOD2;
        }
        long[] pref1 = new long[n + 1];
        long[] pref2 = new long[n + 1];
        for (int i = 0; i < n; i++) {
            pref1[i + 1] = (pref1[i] + (long) nums[i] * pow1[i]) % MOD1;
            pref2[i + 1] = (pref2[i] + (long) nums[i] * pow2[i]) % MOD2;
        }
        long[] target1 = new long[m + 1];
        long[] target2 = new long[m + 1];
        for (int i = 0; i < m; i++) {
            target1[i + 1] = (target1[i] + (long) target[i] * pow1[i]) % MOD1;
            target2[i + 1] = (target2[i] + (long) target[i] * pow2[i]) % MOD2;
        }
        int[] values = nums.clone();
        Arrays.sort(values);
        int[] unique = new int[n];
        int uniqueCnt = 0;
        for (int x : values) {
            if (uniqueCnt == 0 || unique[uniqueCnt - 1] != x) {
                unique[uniqueCnt++] = x;
            }
        }
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            rank[i] = Arrays.binarySearch(unique, 0, uniqueCnt, nums[i]) + 1;
        }
        int segSize = 4 * uniqueCnt + 5;
        hash1 = new long[segSize];
        hash2 = new long[segSize];
        lazy1 = new long[segSize];
        lazy2 = new long[segSize];
        Arrays.fill(lazy1, 1L);
        Arrays.fill(lazy2, 1L);
        int[] bit = new int[uniqueCnt + 1];
        Map<Long, Integer> freq = new HashMap<>();
        int total = 0;
        for (int d = 1; d <= n; d++) {
            int index = n - d;
            int value = nums[index];
            int r = rank[index];
            int less = bitSum(bit, r - 1);
            int exponent = total - less;
            long add1 = (long) value * pow1[exponent] % MOD1;
            long add2 = (long) value * pow2[exponent] % MOD2;
            if (r > 1) {
                rangeMultiply(1, 1, uniqueCnt, 1, r - 1);
            }
            pointAdd(1, 1, uniqueCnt, r, add1, add2);
            for (int i = r; i <= uniqueCnt; i += i & -i) {
                bit[i]++;
            }
            total++;
            long full1 = (pref1[index] + pow1[index] * hash1[1]) % MOD1;
            long full2 = (pref2[index] + pow2[index] * hash2[1]) % MOD2;
            long key = makeKey(full1, full2);
            freq.merge(key, 1, Integer::sum);
        }

        int[] ans = new int[m - n + 1];
        for (int k = 0; k <= m - n; k++) {
            long window1 = (target1[k + n] - target1[k] + MOD1) % MOD1;
            window1 = window1 * invPow1[k] % MOD1;
            long window2 = (target2[k + n] - target2[k] + MOD2) % MOD2;
            window2 = window2 * invPow2[k] % MOD2;
            ans[k] = freq.getOrDefault(makeKey(window1, window2), 0);
        }
        return ans;
    }

    private static long makeKey(long h1, long h2) {
        return (h1 << 32) | (h2 & 0xffffffffL);
    }

    private static int bitSum(int[] bit, int index) {
        int res = 0;
        for (int i = index; i > 0; i -= i & -i) {
            res += bit[i];
        }
        return res;
    }

    private void applyMultiply(int node, long multiplier1, long multiplier2) {
        hash1[node] = hash1[node] * multiplier1 % MOD1;
        lazy1[node] = lazy1[node] * multiplier1 % MOD1;
        hash2[node] = hash2[node] * multiplier2 % MOD2;
        lazy2[node] = lazy2[node] * multiplier2 % MOD2;
    }

    private void push(int node) {
        if (lazy1[node] != 1L || lazy2[node] != 1L) {
            applyMultiply(node << 1, lazy1[node], lazy2[node]);
            applyMultiply(node << 1 | 1, lazy1[node], lazy2[node]);
            lazy1[node] = 1L;
            lazy2[node] = 1L;
        }
    }

    private void rangeMultiply(int node, int left, int right, int queryLeft, int queryRight) {
        if (queryLeft > right || queryRight < left) {
            return;
        }
        if (queryLeft <= left && right <= queryRight) {
            applyMultiply(node, BASE, BASE);
            return;
        }
        push(node);
        int middle = (left + right) >>> 1;
        rangeMultiply(node << 1, left, middle, queryLeft, queryRight);
        rangeMultiply(node << 1 | 1, middle + 1, right, queryLeft, queryRight);
        hash1[node] = (hash1[node << 1] + hash1[node << 1 | 1]) % MOD1;
        hash2[node] = (hash2[node << 1] + hash2[node << 1 | 1]) % MOD2;
    }

    private void pointAdd(int node, int left, int right, int position, long value1, long value2) {
        if (left == right) {
            hash1[node] = (hash1[node] + value1) % MOD1;
            hash2[node] = (hash2[node] + value2) % MOD2;
            return;
        }
        push(node);
        int middle = (left + right) >>> 1;
        if (position <= middle) {
            pointAdd(node << 1, left, middle, position, value1, value2);
        } else {
            pointAdd(node << 1 | 1, middle + 1, right, position, value1, value2);
        }
        hash1[node] = (hash1[node << 1] + hash1[node << 1 | 1]) % MOD1;
        hash2[node] = (hash2[node << 1] + hash2[node << 1 | 1]) % MOD2;
    }

    private static long modPow(long base, long exp, long mod) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) res = res * base % mod;
            base = base * base % mod;
            exp >>= 1;
        }
        return res;
    }
}
/*
4109. 统计有效后缀排序的数量 II
https://leetcode.cn/problems/count-valid-suffix-sorts-ii/description/

第 527 场周赛 T4。

给你两个整数数组 nums 和 target，长度分别为 n 和 m，其中 n <= m。
对于每个下标 i，考虑将原数组的 后缀 nums[i..n - 1] 按 非递增顺序 排序。
返回一个长度为 m - n + 1 的整数数组 ans，其中 ans[k] 表示使排序后的数组等于 target[k..k + n - 1] 的下标 i 的数量。
子数组 是数组中一个连续的 非空 元素序列。
数组的 后缀 是从任意下标开始并延伸至数组末尾的子数组。
示例 1：
输入： nums = [2,2,3], target = [2,2,3,2,1,3,2,2]
输出： [1,1,0,0,0,1]
示例 2：
输入： nums = [5,6,5], target = [5,6,5,5,6,5]
输出： [2,1,0,2]
提示：
n == nums.length
m == target.length
1 <= n <= m <= 10^5
1 <= nums[i], target[i] <= 10^5

滚动哈希表示这 n 个结果数组，并用值域线段树动态维护排序后缀的哈希；再滑动统计 target 的每个长度为 n 的窗口。
时间复杂度 O((n+m) log n)。
 */