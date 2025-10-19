import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class Solution3715 {
    static final int MX = (int) (1e5 + 1);
    static int[] minPrime = new int[MX];
    static int[] core = new int[MX];

    static {
        Arrays.fill(minPrime, 0);
        for (int i = 2; i < MX; i++) {
            if (minPrime[i] == 0) {
                minPrime[i] = i;
                for (int j = i * 2; j < MX; j += i) {
                    if (minPrime[j] == 0) {
                        minPrime[j] = i;
                    }
                }
            }
        }
        for (int i = 1; i < MX; i++) {
            int temp = i;
            int res = 1;
            while (temp > 1) {
                int p = minPrime[temp];
                int count = 0;
                while (temp % p == 0) {
                    count++;
                    temp /= p;
                }
                if (count % 2 == 1) {
                    res *= p;
                }
            }
            core[i] = res;
        }
    }

    public long sumOfAncestors(int n, int[][] edges, int[] nums) {
        ArrayList<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] p : edges) {
            g[p[0]].add(p[1]);
            g[p[1]].add(p[0]);
        }

        int[] freq = new int[MX];
        long ans = 0;
        freq[core[nums[0]]]++;

        Deque<int[]> st = new ArrayDeque<>();
        st.push(new int[]{0, -1, 0});
        while (!st.isEmpty()) {
            int[] cur = st.peek();
            int u = cur[0];
            int parent = cur[1];
            int idx = cur[2];
            if (idx < g[u].size()) {
                int v = g[u].get(idx);
                cur[2]++;
                if (v == parent) {
                    continue;
                }
                int c = core[nums[v]];
                ans += freq[c];
                freq[c]++;
                st.push(new int[]{v, u, 0});
            } else {
                st.pop();
                if (u != 0) {
                    int c = core[nums[u]];
                    freq[c]--;
                }
            }
        }

        return ans;
    }
}
/*
3715. 完全平方数的祖先个数总和
https://leetcode.cn/problems/sum-of-perfect-square-ancestors/description/

第 471 场周赛 T4。

给你一个整数 n，以及一棵以节点 0 为根、包含 n 个节点（编号从 0 到 n - 1）的无向树。该树由一个长度为 n - 1 的二维数组 edges 表示，其中 edges[i] = [ui, vi] 表示在节点 ui 与节点 vi 之间有一条无向边。
同时给你一个整数数组 nums，其中 nums[i] 是分配给节点 i 的正整数。
定义值 ti 为：节点 i 的 祖先 节点中，满足乘积 nums[i] * nums[ancestor] 为 完全平方数 的祖先个数。
请返回所有节点 i（范围为 [1, n - 1]）的 ti 之和。
说明：
- 在有根树中，节点 i 的祖先是指从节点 i 到根节点 0 的路径上、不包括 i 本身的所有节点。
- 完全平方数是可以表示为某个整数与其自身乘积的数，例如 1、4、9、16。
提示：
1 <= n <= 10^5
edges.length == n - 1
edges[i] = [ui, vi]
0 <= ui, vi <= n - 1
nums.length == n
1 <= nums[i] <= 10^5
输入保证 edges 表示一棵有效的树。

1、问题分析：我们需要找到每个非根节点的祖先节点，使得它们的数字乘积为完全平方数。关键在于理解两个数的乘积为完全平方数的条件，即它们的无平方因子核心必须相同。
2、核心计算：对于每个数字，计算其无平方因子核心，即去除所有偶数次质因数后的乘积。例如，数字8（2^3）的核心是2，因为3模2为1。
3、树遍历：使用深度优先搜索（DFS）遍历树，维护一个频率数组记录当前路径上各核心值的出现次数。对于每个非根节点，其有效祖先数即为当前路径上与其核心值相同的节点数。
4、迭代DFS：为避免递归深度过大，采用迭代DFS。处理每个节点时，先统计有效祖先数，更新频率数组，然后处理子节点，回溯时减少频率。
https://chat.deepseek.com/a/chat/s/db5c96f2-ff8d-4df2-a910-3b1db5122f23
时间复杂度 O(n)。
---
无平方因子核 core + 枚举右维护左
https://leetcode.cn/problems/sum-of-perfect-square-ancestors/solutions/3803792/ping-fang-sheng-yu-he-mei-ju-you-wei-hu-bfyxy/
相似题目: 2862. 完全子集的最大元素和
https://leetcode.cn/problems/maximum-element-sum-of-a-complete-subset-of-indices/
rating 2259 (clist.by)
 */