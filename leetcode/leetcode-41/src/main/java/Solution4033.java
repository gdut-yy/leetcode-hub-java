import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Solution4033 {
    public boolean[] validSubarrays(int[] nums, int k, int[][] queries) {
        int n = nums.length;
        Random rnd = new Random();
        Map<Integer, Long> hashOf = new HashMap<>();
        long[] px = new long[n + 1];
        for (int i = 0; i < n; i++) {
            long h = hashOf.computeIfAbsent(nums[i], v -> {
                long x = rnd.nextLong();
                return x == 0 ? 1 : x;
            });
            px[i + 1] = px[i] ^ h;
        }

        int q = queries.length;
        boolean[] ans = new boolean[q];
        int[] head = new int[n];
        int[] next = new int[q];
        int[] lArr = new int[q];
        Arrays.fill(head, -1);
        for (int i = 0; i < q; i++) {
            lArr[i] = queries[i][0];
            next[i] = head[queries[i][1]];
            head[queries[i][1]] = i;
        }

        int[] bit = new int[n + 1];
        int[] last = new int[100001];
        Arrays.fill(last, -1);
        for (int r = 0; r < n; r++) {
            int v = nums[r];
            if (last[v] != -1) add(bit, last[v] + 1, -1);
            add(bit, r + 1, 1);
            last[v] = r;
            for (int qi = head[r]; qi != -1; qi = next[qi]) {
                int l = lArr[qi];
                int distinct = sum(bit, r + 1) - sum(bit, l);
                ans[qi] = distinct == k && px[l] == px[r + 1];
            }
        }
        return ans;
    }

    private void add(int[] bit, int i, int delta) {
        for (; i < bit.length; i += i & -i) bit[i] += delta;
    }

    private int sum(int[] bit, int i) {
        int s = 0;
        for (; i > 0; i -= i & -i) s += bit[i];
        return s;
    }
}
/*
4033. 有效 K 个不同元素子数组 I
https://leetcode.cn/problems/valid-k-unique-subarrays-i/description/

第 516 场周赛 T4。

给定一个整数数组 nums 和一个整数 k。
同时给定一个二维整数数组 queries，其中 queries[i] = [li, ri] 表示子数组 nums[li..ri]。
对于每个查询，如果子数组 nums[li..ri] 满足以下条件，则认为该 子数组 是 有效的：
- 它 恰好 包含 k 个 不同 的数字，并且
- 子数组中每个数字出现的 频率 都是 偶数。
返回一个布尔数组 ans，其中如果 nums[li..ri] 是 有效的，则 ans[i] 为 true，否则为 false。
提示：
2 <= n == nums.length <= 10^5
1 <= nums[i] <= 10^5
1 <= k <= n
1 <= queries.length <= 10^5
queries[i] == [li, ri]
0 <= li < ri <= n - 1

异或哈希 + 滑动窗口。
时间复杂度 O(n + q)。
 */