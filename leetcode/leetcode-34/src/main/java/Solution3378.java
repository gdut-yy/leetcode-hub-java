import java.util.Arrays;

public class Solution3378 {
    public int countComponents(int[] nums, int threshold) {
        int n = nums.length;
        // 记录每个数的下标
        int[] idx = new int[threshold + 1];
        Arrays.fill(idx, -1);
        for (int i = 0; i < n; i++) {
            if (nums[i] <= threshold) {
                idx[nums[i]] = i;
            }
        }

        DSU dsu = new DSU(n);
        for (int g = 1; g <= threshold; g++) {
            int minX = -1;
            for (int x = g; x <= threshold; x += g) {
                if (idx[x] >= 0) {
                    minX = x;
                    break;
                }
            }
            if (minX < 0) {
                continue;
            }
            int fi = dsu.find(idx[minX]);
            int upper = (int) ((long) g * threshold / minX);
            for (int y = minX + g; y <= upper; y += g) {
                if (idx[y] >= 0) {
                    dsu.union(fi, idx[y]);
                }
            }
        }
        return dsu.sz;
    }

    static class DSU {
        int[] fa;
        int sz;

        public DSU(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) fa[i] = i;
            sz = n;
        }

        int find(int x) { // 查找
            return x == fa[x] ? fa[x] : (fa[x] = find(fa[x]));
        }

        void union(int p, int q) { // 合并
            p = find(p);
            q = find(q);
            if (p == q) return;
            fa[q] = p;
            sz--;
        }
    }
}
/*
3378. 统计最小公倍数图中的连通块数目
https://leetcode.cn/problems/count-connected-components-in-lcm-graph/description/

第 145 场双周赛 T4。

给你一个长度为 n 的整数数组 nums 和一个 正 整数 threshold 。
有一张 n 个节点的图，其中第 i 个节点的值为 nums[i] 。如果两个节点对应的值满足 lcm(nums[i], nums[j]) <= threshold ，那么这两个节点在图中有一条 无向 边连接。
请你返回这张图中 连通块 的数目。
一个 连通块 指的是一张图中的一个子图，子图中任意两个节点都存在路径相连，且子图中没有任何一个节点与子图以外的任何节点有边相连。
lcm(a, b) 的意思是 a 和 b 的 最小公倍数 。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9
nums 中所有元素互不相同。
1 <= threshold <= 2 * 10^5

rating 2465 (clist.by)
 */