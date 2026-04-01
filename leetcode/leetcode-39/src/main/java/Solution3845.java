import java.util.ArrayDeque;

public class Solution3845 {
    public int maxXor(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] ^ nums[i];
        }

        Trie01 t = new Trie01(n, 15);
        ArrayDeque<Integer> minQ = new ArrayDeque<>(); // 更快的写法见【Java 数组】
        ArrayDeque<Integer> maxQ = new ArrayDeque<>();
        int ans = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            // 1. 入
            t.insert(sum[right], 1);

            int x = nums[right];
            while (!minQ.isEmpty() && x <= nums[minQ.peekLast()]) {
                minQ.pollLast();
            }
            minQ.addLast(right);

            while (!maxQ.isEmpty() && x >= nums[maxQ.peekLast()]) {
                maxQ.pollLast();
            }
            maxQ.addLast(right);

            // 2. 出
            while (nums[maxQ.peekFirst()] - nums[minQ.peekFirst()] > k) {
                t.insert(sum[left], -1);
                left++;
                if (minQ.peekFirst() < left) {
                    minQ.pollFirst();
                }
                if (maxQ.peekFirst() < left) {
                    maxQ.pollFirst();
                }
            }

            // 3. 更新答案
            ans = Math.max(ans, t.max_xor(sum[right + 1]));
        }

        return ans;
    }

    static class Trie01 {
        int[][] dict;
        int[] cnt;
        int nextIdx, m;

        // n:长度 m:2^m
        public Trie01(int n, int m) {
            this.dict = new int[2][n * m + 2];
            this.cnt = new int[n * m + 2];
            this.nextIdx = 1;
            this.m = m;
        }

        // op:1 插入 op:-1 删除
        public void insert(int x, int op) {
            int idx = 0;
            for (int k = m - 1; k >= 0; k--) {
                int pos = x >> k & 1;
                if (dict[pos][idx] == 0) {
                    dict[pos][idx] = nextIdx++;
                }
                idx = dict[pos][idx];
                cnt[idx] += op;
            }
        }

        public int max_xor(int x) {
            int res = 0;
            int idx = 0;
            for (int k = m - 1; k >= 0; k--) {
                int pos = x >> k & 1;
                // 优先选择与当前位相同的位，如果不存在或者计数为0，则选择相反的位
                if (cnt[dict[1 ^ pos][idx]] != 0) {
                    res |= 1 << k;
                    idx = dict[1 ^ pos][idx];
                } else {
                    idx = dict[pos][idx];
                }
            }
            return res;
        }
    }
}
/*
3845. 最大子数组异或值
https://leetcode.cn/problems/maximum-subarray-xor-with-bounded-range/description/

第 489 场周赛 T4。

给你一个非负整数数组 nums 和一个整数 k。
你需要选择 nums 的一个 子数组，使得该子数组中元素的 最大值 与 最小值 之间的差值不超过 k。这个子数组的 值 定义为子数组中所有元素按位异或（XOR）的结果。
返回一个整数，表示所选子数组可能获得的 最大值 。
子数组 是数组中任意连续、非空 的元素序列。
提示：
1 <= nums.length <= 4 * 10^4
0 <= nums[i] < 2^15
0 <= k < 2^15

0-1 字典树。
时间复杂度 O(nlogU)。其中 U=max(nums)。
 */