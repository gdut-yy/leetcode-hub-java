import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution3575 {
    private long ans = 0;

    public int goodSubtreeSum(int[] vals, int[] par) {
        int n = par.length;
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int i = 1; i < n; i++) {
            g[par[i]].add(i);
        }

        dfs(0, vals, g);
        return (int) (ans % 1_000_000_007);
    }

    // 返回每种 mask 下的最大子树和
    private Map<Integer, Integer> dfs(int x, int[] vals, List<Integer>[] g) {
        Map<Integer, Integer> f = new HashMap<>();

        // 计算 vals[x] 的数位集合 mask
        int mask = 0;
        for (int v = vals[x]; v > 0; v /= 10) {
            int d = v % 10;
            if ((mask >> d & 1) > 0) { // d 在集合 mask 中
                mask = 0; // 不符合要求
                break;
            }
            mask |= 1 << d; // 把 d 加到集合 mask 中
        }

        if (mask > 0) {
            f.put(mask, vals[x]);
        }

        for (int y : g[x]) {
            Map<Integer, Integer> fy = dfs(y, vals, g);
            Map<Integer, Integer> nf = new HashMap<>(f);
            for (Map.Entry<Integer, Integer> e : fy.entrySet()) {
                int msk = e.getKey();
                int s = e.getValue();
                // 同一个 mask 至多选一个，直接取 max
                nf.merge(msk, s, Math::max);
                // 求两个 mask 的并集，刷表转移
                for (Map.Entry<Integer, Integer> e2 : f.entrySet()) {
                    int msk2 = e2.getKey();
                    if ((msk & msk2) == 0) {
                        nf.merge(msk | msk2, s + e2.getValue(), Math::max);
                    }
                }
            }
            f = nf;
        }

        if (!f.isEmpty()) {
            ans += Collections.max(f.values());
        }

        return f;
    }
}
/*
3575. 最大好子树分数
https://leetcode.cn/problems/maximum-good-subtree-score/description/

第 158 场双周赛 T4。

给你一个根节点为 0 的无向树，包含 n 个节点，编号从 0 到 n - 1。每个节点 i 都有一个整数值 vals[i]，其父节点为 par[i] 。
从一个节点 子树 内选取部分节点，它们的数值组成一个 子集 ，如果所选数值的十进制表示中，从 0 到 9 每个数字在所有数的数位最多出现一次，那么我们称它是 好 子集。
一个好子集的 分数 是其节点值的总和。
定义一个长度为 n 的数组 maxScore，其中 maxScore[u] 表示以节点 u 为根的子树（包括 u 本身及其所有后代）中，好子集的最大可能值总和。
返回 maxScore 中所有值的总和。
由于答案可能很大，请将其对 10^9 + 7 取模 后返回。
数组的 子集 是选取数组中元素得到的集合（可能为空）。
提示:
1 <= n == vals.length <= 500
1 <= vals[i] <= 10^9
par.length == n
par[0] == -1
对于 [1, n - 1] 中的每一个 i ，都有 0 <= par[i] < n 。
输入生成保证父数组 par 表示一棵有效的树。

树形 DP + 状态压缩 + 启发式合并
https://leetcode.cn/problems/maximum-good-subtree-score/solutions/3695614/shu-xing-dp-mei-ju-zi-ji-by-endlesscheng-e2je/
rating 2350 (clist.by)
 */