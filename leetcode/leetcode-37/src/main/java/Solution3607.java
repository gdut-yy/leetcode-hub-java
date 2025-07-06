import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class Solution3607 {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        DSU dsu = new DSU(c + 1);
        for (int[] conn : connections) {
            int u = conn[0], v = conn[1];
            dsu.union(u, v);
        }

        TreeSet<Integer>[] setList = new TreeSet[c + 1];
        Arrays.setAll(setList, e -> new TreeSet<>());
        for (int i = 1; i <= c; i++) {
            int r = dsu.find(i);
            setList[r].add(i);
        }

        boolean[] online = new boolean[c + 1];
        Arrays.fill(online, true);

        List<Integer> ans = new ArrayList<>();
        for (int[] q : queries) {
            int type = q[0], node = q[1];
            if (type == 2) {
                online[node] = false;
                int r = dsu.find(node);
                setList[r].remove(node);
            } else {
                if (online[node]) {
                    ans.add(node);
                } else {
                    int r = dsu.find(node);
                    if (setList[r].isEmpty()) {
                        ans.add(-1);
                    } else {
                        ans.add(setList[r].first());
                    }
                }
            }
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    static class DSU {
        int[] fa;

        public DSU(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) fa[i] = i;
        }

        int find(int x) { // 查找
            return x == fa[x] ? fa[x] : (fa[x] = find(fa[x]));
        }

        void union(int p, int q) { // 合并
            p = find(p);
            q = find(q);
            if (p == q) return;
            // 小值作为根
            if (p < q) fa[q] = p;
            else fa[p] = q;
        }
    }
}
/*
3607. 电网维护
https://leetcode.cn/problems/power-grid-maintenance/description/

第 457 场周赛 T2。

给你一个整数 c，表示 c 个电站，每个电站有一个唯一标识符 id，从 1 到 c 编号。
这些电站通过 n 条 双向 电缆互相连接，表示为一个二维数组 connections，其中每个元素 connections[i] = [ui, vi] 表示电站 ui 和电站 vi 之间的连接。直接或间接连接的电站组成了一个 电网 。
最初，所有 电站均处于在线（正常运行）状态。
另给你一个二维数组 queries，其中每个查询属于以下 两种类型之一 ：
- [1, x]：请求对电站 x 进行维护检查。如果电站 x 在线，则它自行解决检查。如果电站 x 已离线，则检查由与 x 同一 电网 中 编号最小 的在线电站解决。如果该电网中 不存在 任何 在线 电站，则返回 -1。
- [2, x]：电站 x 离线（即变为非运行状态）。
返回一个整数数组，表示按照查询中出现的顺序，所有类型为 [1, x] 的查询结果。
注意：电网的结构是固定的；离线（非运行）的节点仍然属于其所在的电网，且离线操作不会改变电网的连接性。
提示：
1 <= c <= 10^5
0 <= n == connections.length <= min(10^5, c * (c - 1) / 2)
connections[i].length == 2
1 <= ui, vi <= c
ui != vi
1 <= queries.length <= 2 * 10^5
queries[i].length == 2
queries[i][0] 为 1 或 2。
1 <= queries[i][1] <= c

并查集 + 有序集合。
 */