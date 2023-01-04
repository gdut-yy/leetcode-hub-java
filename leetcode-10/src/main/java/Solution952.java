import java.util.Arrays;

public class Solution952 {
    public int largestComponentSize(int[] nums) {
        int max = Arrays.stream(nums).max().orElseThrow();

        DSU dsu = new DSU(max + 1);
        for (int num : nums) {
            dsu.sz[num] = 1;
        }
        for (int num : nums) {
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    dsu.union(num, i);
                    dsu.union(num, num / i);
                }
            }
        }

        return Arrays.stream(dsu.sz).max().orElseThrow();
    }

    private static class DSU {
        int[] fa;
        int[] sz;

        public DSU(int n) {
            int N = n + 1;
            fa = new int[N];
            sz = new int[N];
            for (int i = 0; i < N; i++) {
                fa[i] = i;
//                sz[i] = 1;
            }
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
                sz[rootP] += sz[rootQ];
            } else {
                fa[rootP] = rootQ;
                sz[rootQ] += sz[rootP];
            }
        }
    }
}
/*
952. 按公因数计算最大组件大小
https://leetcode.cn/problems/largest-component-size-by-common-factor/

给定一个由不同正整数的组成的非空数组 nums ，考虑下面的图：
- 有 nums.length 个节点，按从 nums[0] 到 nums[nums.length - 1] 标记；
- 只有当 nums[i] 和 nums[j] 共用一个大于 1 的公因数时，nums[i] 和 nums[j]之间才有一条边。
返回 图中最大连通组件的大小 。
提示：
1 <= nums.length <= 2 * 10^4
1 <= nums[i] <= 10^5
nums 中所有值都 不同

并查集连公因数
相似题目: 1998. 数组的最大公因数排序
https://leetcode.cn/problems/gcd-sort-of-an-array/
 */