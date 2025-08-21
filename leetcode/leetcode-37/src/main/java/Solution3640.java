public class Solution3640 {
    public long maxSumTrionic(int[] nums) {
        int n = nums.length;
        long[] pre = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + nums[i - 1];
        }

        long[] minPre = new long[n];
        minPre[0] = Long.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                if (minPre[i - 1] == Long.MAX_VALUE) {
                    minPre[i] = pre[i - 1];
                } else {
                    minPre[i] = Math.min(minPre[i - 1], pre[i - 1]);
                }
            } else {
                minPre[i] = Long.MAX_VALUE;
            }
        }

        long[] maxSuf = new long[n];
        maxSuf[n - 1] = Long.MIN_VALUE;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                if (i <= n - 3) {
                    maxSuf[i] = Math.max(pre[i + 2], maxSuf[i + 1]);
                } else {
                    maxSuf[i] = pre[i + 2];
                }
            } else {
                maxSuf[i] = Long.MIN_VALUE;
            }
        }

        int[] nextDec = new int[n];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (j < i + 1) {
                j = i + 1;
            }
            while (j < n && nums[j - 1] > nums[j]) {
                j++;
            }
            nextDec[i] = j;
        }

        ST st = new ST(maxSuf);
        long ans = Long.MIN_VALUE;
        for (int p = 1; p <= n - 3; p++) {
            if (minPre[p] == Long.MAX_VALUE) continue;
            int q_end = nextDec[p] - 1;
            if (q_end < p + 1) continue;
            if (q_end > n - 2) q_end = n - 2;
            long maxSufVal = st.query(p + 1, q_end);
            if (maxSufVal == Long.MIN_VALUE) continue;
            long total = maxSufVal - minPre[p];
            if (total > ans) {
                ans = total;
            }
        }
        return ans;
    }

    static class ST {
        long[][] st;
        int[] log;
        int n;

        public ST(long[] arr) {
            n = arr.length;
            log = new int[n + 1];
            log[0] = -1;
            for (int i = 1; i <= n; i++) {
                log[i] = log[i >> 1] + 1;
            }
            int maxLog = log[n];
            st = new long[n][maxLog + 1];
            for (int i = 0; i < n; i++) {
                st[i][0] = arr[i];
            }
            for (int j = 1; j <= maxLog; j++) {
                for (int i = 0; i + (1 << j) - 1 < n; i++) {
                    st[i][j] = Math.max(st[i][j - 1], st[i + (1 << (j - 1))][j - 1]);
                }
            }
        }

        public long query(int l, int r) {
            int len = r - l + 1;
            int k = log[len];
            return Math.max(st[l][k], st[r - (1 << k) + 1][k]);
        }
    }
}
/*
3640. 三段式数组 II
https://leetcode.cn/problems/trionic-array-ii/description/

第 461 场周赛 T4。

给你一个长度为 n 的整数数组 nums。
三段式子数组 是一个连续子数组 nums[l...r]（满足 0 <= l < r < n），并且存在下标 l < p < q < r，使得：
- nums[l...p] 严格 递增，
- nums[p...q] 严格 递减，
- nums[q...r] 严格 递增。
请你从数组 nums 的所有三段式子数组中找出和最大的那个，并返回其 最大 和。
提示:
4 <= n = nums.length <= 10^5
-10^9 <= nums[i] <= 10^9
保证至少存在一个三段式子数组。

预处理前缀和、左右递增数组 + ST表 + 枚举中间点。
时间复杂度 O(n)。
分组循环，O(n) 时间，O(1) 空间 https://leetcode.cn/problems/trionic-array-ii/solutions/3741020/fen-zu-xun-huan-on-shi-jian-o1-kong-jian-ewr5/
https://chat.deepseek.com/a/chat/s/64e08208-ef54-46f9-885a-4ffa2188cf12
rating 2280 (clist.by)
 */