import java.util.Arrays;

public class Solution6464 {
    public boolean canTraverseAllPairs(int[] nums) {
        int n = nums.length;

        // 特判
        if (n == 1) return true;
        int min = Arrays.stream(nums).min().orElseThrow();
        if (min == 1) return false;

        int max = Arrays.stream(nums).max().orElseThrow();
        DSU dsu = new DSU(max);
        for (int num : nums) {
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    dsu.union(num, i);
                    dsu.union(num, num / i);
                }
            }
        }

        int root = dsu.find(nums[0]);
        for (int i = 1; i < n; i++) {
            if (dsu.find(nums[i]) == root) continue;
            return false;
        }
        return true;
    }

    private static class DSU {
        int[] fa;
        int sz;

        public DSU(int n) {
            int N = n + 1;
            fa = new int[N];
            for (int i = 0; i < N; i++) {
                fa[i] = i;
            }
            sz = n;
        }

        int find(int x) {
            if (x != fa[x]) {
                fa[x] = find(fa[x]);
            }
            return fa[x];
        }

        void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            // 合并到较小的节点
            if (rootP < rootQ) {
                fa[rootQ] = rootP;
            } else {
                fa[rootP] = rootQ;
            }
            sz--;
        }
    }
}
/*
6464. 最大公约数遍历
https://leetcode.cn/problems/greatest-common-divisor-traversal/

第 105 场双周赛 T4。

给你一个下标从 0 开始的整数数组 nums ，你可以在一些下标之间遍历。对于两个下标 i 和 j（i != j），当且仅当 gcd(nums[i], nums[j]) > 1 时，我们可以在两个下标之间通行，其中 gcd 是两个数的 最大公约数 。
你需要判断 nums 数组中 任意 两个满足 i < j 的下标 i 和 j ，是否存在若干次通行可以从 i 遍历到 j 。
如果任意满足条件的下标对都可以遍历，那么返回 true ，否则返回 false 。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^5

并查集。
时间复杂度 O(nlogA)
相似题目: 952. 按公因数计算最大组件大小
https://leetcode.cn/problems/largest-component-size-by-common-factor/
1998. 数组的最大公因数排序
https://leetcode.cn/problems/gcd-sort-of-an-array/
D. Friendly Spiders
https://codeforces.com/contest/1775/problem/D
 */