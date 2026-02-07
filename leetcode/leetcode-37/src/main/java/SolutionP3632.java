public class SolutionP3632 {
    public long countXorSubarrays(int[] nums, int k) {
        int n = nums.length;
        long ans = 0;
        int sum = 0;
        Trie01 trie = new Trie01(n + 1, 30);
        trie.insert(0);
        for (int v : nums) {
            sum ^= v;
            ans += trie.cal(sum, k);
            trie.insert(sum);
        }
        return ans;
    }

    static class Trie01 {
        int[][] tree;
        int[] cnt;
        int m, tot;

        public Trie01(int n, int m) {
            tree = new int[2][n * m + 2];
            cnt = new int[n * m + 2];
            this.m = m;
            tot = 1;
        }

        void insert(int val) {
            insert(val, m, 1);
        }

        void insert(int val, int i, int cur) {
            if (i < 0) {
                cnt[cur]++;
                return;
            }
            int b = (val >> i) & 1;
            if (tree[b][cur] == 0) {
                tree[b][cur] = ++tot;
                tree[0][tot] = tree[1][tot] = 0;
                cnt[tot] = 0;
            }
            insert(val, i - 1, tree[b][cur]);
            cnt[cur] = cnt[tree[0][cur]] + cnt[tree[1][cur]];
        }

        // >= k
        int cal(int val, int k) {
            int cur = 1; // root
            int ans = 0;
            for (int i = m; i >= 0; --i) {
                int b = (val >> i) & 1, kb = (k >> i) & 1;
                if (kb == 0) ans += cnt[tree[b ^ 1][cur]];
                cur = tree[kb ^ b][cur];
            }
            return ans + cnt[cur];
        }
    }
}
/*
$3632. 异或至少为 K 的子数组数目
https://leetcode.cn/problems/subarrays-with-xor-at-least-k/description/

给你一个长度为 n 的正整数数组 nums 和一个非负整数 k。
返回所有元素按位异或结果 大于 或 等于 k 的 连续子数组 的数目。
提示:
1 <= nums.length <= 10^5
0 <= nums[i] <= 10^9
0 <= k <= 10^9

0-1 Trie
https://leetcode.cn/problems/subarrays-with-xor-at-least-k/solutions/3739197/01trie-by-xiao-shu-lin-f-948e/
 */