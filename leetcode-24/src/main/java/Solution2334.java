import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Solution2334 {
    public int validSubarraySize(int[] nums, int threshold) {
        int n = nums.length;

        List<Integer> idxList = new ArrayList<>(IntStream.range(0, n).boxed().toList());
        idxList.sort((o1, o2) -> Integer.compare(nums[o2], nums[o1]));

        UnionFind unionFind = new UnionFind(n);
        for (int i : idxList) {
            int faI = unionFind.find(i);
            int faJ = unionFind.find(i + 1);
            // 贪心，优先 union 较大的数
            unionFind.union(faI, faJ);

            int k = unionFind.sz[faI] - 1;
            if (nums[i] > threshold / k) {
                return k;
            }
        }
        return -1;
    }

    private static class UnionFind {
        int[] fa;
        int[] sz;

        public UnionFind(int n) {
            int N = n + 1;
            fa = new int[N];
            sz = new int[N];
            for (int i = 0; i < N; i++) {
                fa[i] = i;
                sz[i] = 1;
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
2334. 元素值大于变化阈值的子数组
https://leetcode.cn/problems/subarray-with-elements-greater-than-varying-threshold/

第 82 场双周赛 T4。

给你一个整数数组 nums 和一个整数 threshold 。
找到长度为 k 的 nums 子数组，满足数组中 每个 元素都 大于 threshold / k 。
请你返回满足要求的 任意 子数组的 大小 。如果没有这样的子数组，返回 -1 。
子数组 是数组中一段连续非空的元素序列。
提示：
1 <= nums.length <= 10^5
1 <= nums[i], threshold <= 10^9

并查集
 */