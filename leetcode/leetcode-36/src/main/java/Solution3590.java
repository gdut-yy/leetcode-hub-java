import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution3590 {
    // 离散化 + 树上启发式合并 + 树状数组
    static class V1 {
        List<Integer>[] g;
        int[] vals;
        Map<Integer, List<int[]>> queryMap;
        Map<Integer, Integer> map;
        BIT tr;
        int[] xor, sz, heavy, distinct, cntArr, ans;

        public int[] kthSmallest(int[] par, int[] vals, int[][] queries) {
            int n = vals.length;
            int q = queries.length;
            g = new ArrayList[n];
            Arrays.setAll(g, e -> new ArrayList<>());
            for (int i = 1; i < n; i++) {
                g[par[i]].add(i);
            }
            this.vals = vals;

            xor = new int[n];
            sz = new int[n];
            heavy = new int[n];
            Arrays.fill(heavy, -1);
            calcXor(0, 0);

            dfs2(0);

            queryMap = new HashMap<>();
            for (int i = 0; i < q; i++) {
                int u = queries[i][0];
                int kj = queries[i][1];
                queryMap.computeIfAbsent(u, k -> new ArrayList<>()).add(new int[]{kj, i});
            }

            int[] allXor = Arrays.copyOf(xor, n);
            Arrays.sort(allXor);
            int m = 0;
            for (int i = 1; i < n; i++) {
                if (allXor[i] != allXor[m]) {
                    allXor[++m] = allXor[i];
                }
            }
            distinct = Arrays.copyOf(allXor, m + 1);
            map = new HashMap<>();
            for (int i = 0; i <= m; i++) {
                map.put(distinct[i], i + 1);
            }
            int M = m + 1;

            tr = new BIT(M);
            cntArr = new int[M + 1];
            ans = new int[q];

            dfs(0, true);
            return ans;
        }

        private void calcXor(int u, int prevXor) {
            xor[u] = prevXor ^ vals[u];
            for (int v : g[u]) {
                calcXor(v, xor[u]);
            }
        }

        private void dfs2(int u) {
            sz[u] = 1;
            int maxSize = 0;
            for (int v : g[u]) {
                dfs2(v);
                sz[u] += sz[v];
                if (sz[v] > maxSize) {
                    maxSize = sz[v];
                    heavy[u] = v;
                }
            }
        }

        private void add(int u) {
            int x = xor[u];
            int id = map.get(x);
            if (cntArr[id] == 0) {
                tr.add(id, 1);
            }
            cntArr[id]++;
        }

        private void remove(int u) {
            int x = xor[u];
            int id = map.get(x);
            cntArr[id]--;
            if (cntArr[id] == 0) {
                tr.add(id, -1);
            }
        }

        private void addTree(int u) {
            Deque<int[]> st = new ArrayDeque<>();
            st.push(new int[]{u, 0});
            while (!st.isEmpty()) {
                int[] curInfo = st.pop();
                int node = curInfo[0];
                int idx = curInfo[1];
                if (idx == 0) {
                    add(node);
                }
                if (idx < g[node].size()) {
                    int next = g[node].get(idx);
                    st.push(new int[]{node, idx + 1});
                    st.push(new int[]{next, 0});
                }
            }
        }

        private void removeTree(int u) {
            Deque<int[]> st = new ArrayDeque<>();
            st.push(new int[]{u, 0});
            while (!st.isEmpty()) {
                int[] curInfo = st.pop();
                int node = curInfo[0];
                int idx = curInfo[1];
                if (idx == 0) {
                    remove(node);
                }
                if (idx < g[node].size()) {
                    int next = g[node].get(idx);
                    st.push(new int[]{node, idx + 1});
                    st.push(new int[]{next, 0});
                }
            }
        }

        private void dfs(int u, boolean keep) {
            for (int v : g[u]) {
                if (v == heavy[u]) continue;
                dfs(v, false);
            }
            if (heavy[u] != -1) {
                dfs(heavy[u], true);
            }
            add(u);
            for (int v : g[u]) {
                if (v == heavy[u]) continue;
                addTree(v);
            }
            if (queryMap.containsKey(u)) {
                for (int[] q : queryMap.get(u)) {
                    int kj = q[0];
                    int idx = q[1];
                    int total = tr.query(tr.n);
                    if (total < kj) {
                        ans[idx] = -1;
                    } else {
                        int left = 1, right = tr.n;
                        while (left < right) {
                            int mid = left + (right - left) / 2;
                            if (tr.query(mid) >= kj) {
                                right = mid;
                            } else {
                                left = mid + 1;
                            }
                        }
                        ans[idx] = distinct[left - 1];
                    }
                }
            }
            if (!keep) {
                removeTree(u);
            }
        }

        static class BIT {
            int n;
            int[] tree;

            public BIT(int n) {
                this.n = n;
                tree = new int[n + 1];
            }

            int lb(int x) {
                return x & -x;
            }

            void add(int pos, int val) {
                for (; pos <= n; pos += lb(pos)) tree[pos] += val;
            }

            int query(int pos) {
                int ret = 0;
                for (; pos > 0; pos -= lb(pos)) ret += tree[pos];
                return ret;
            }
        }
    }

    // 离散化 + 树上启发式合并 + 线段树上二分
    static class V2 {
        List<Integer>[] g;
        int[] vals;
        int[] xor, size, son, ans;
        List<int[]>[] queryGroup;

        static class Node {
            Node l, r;
            int sum;
        }

        public int[] kthSmallest(int[] par, int[] vals, int[][] queries) {
            int n = vals.length;
            int q = queries.length;
            g = new ArrayList[n];
            Arrays.setAll(g, e -> new ArrayList<>());
            for (int i = 1; i < n; i++) {
                g[par[i]].add(i);
            }
            this.vals = vals;

            xor = new int[n];
            calcXor(0, 0);
            List<Integer> allValsList = new ArrayList<>();
            for (int x : xor) {
                allValsList.add(x);
            }
            Collections.sort(allValsList);
            Map<Integer, Integer> map = new HashMap<>();
            int idx = 0;
            List<Integer> distinctVals = new ArrayList<>();
            for (int i = 0; i < allValsList.size(); i++) {
                if (i == 0 || !allValsList.get(i).equals(allValsList.get(i - 1))) {
                    int x = allValsList.get(i);
                    map.put(x, idx);
                    distinctVals.add(x);
                    idx++;
                }
            }
            int valSize = distinctVals.size();

            size = new int[n];
            son = new int[n];
            Arrays.fill(son, -1);
            dfs1(0);

            queryGroup = new ArrayList[n];
            Arrays.setAll(queryGroup, e -> new ArrayList<>());
            for (int i = 0; i < q; i++) {
                int u = queries[i][0];
                int k = queries[i][1];
                queryGroup[u].add(new int[]{i, k});
            }

            ans = new int[q];
            dfs2(0, true, map, distinctVals, valSize);

            return ans;
        }

        private void calcXor(int u, int prevXor) {
            xor[u] = prevXor ^ vals[u];
            for (int v : g[u]) {
                calcXor(v, xor[u]);
            }
        }

        void dfs1(int u) {
            size[u] = 1;
            for (int v : g[u]) {
                dfs1(v);
                size[u] += size[v];
                if (son[u] == -1 || size[v] > size[son[u]]) {
                    son[u] = v;
                }
            }
        }

        Node dfs2(int u, boolean keep, Map<Integer, Integer> map, List<Integer> distinctVals, int valSize) {
            Node root = null;
            if (son[u] != -1) {
                root = dfs2(son[u], true, map, distinctVals, valSize);
            }
            for (int v : g[u]) {
                if (v == son[u]) continue;
                Node childTree = dfs2(v, false, map, distinctVals, valSize);
                root = merge(root, childTree, 0, valSize - 1);
            }
            int x = map.get(xor[u]);
            root = insert(root, 0, valSize - 1, x);
            for (int[] q : queryGroup[u]) {
                int qIdx = q[0];
                int k = q[1];
                if (root == null || root.sum < k) {
                    ans[qIdx] = -1;
                } else {
                    int pos = query(root, 0, valSize - 1, k);
                    ans[qIdx] = distinctVals.get(pos);
                }
            }
            if (!keep) {
                return root;
            }
            return root;
        }

        Node merge(Node a, Node b, int l, int r) {
            if (a == null) return b;
            if (b == null) return a;
            if (l == r) {
                a.sum = 1;
                return a;
            }
            int mid = (l + r) >>> 1;
            a.l = merge(a.l, b.l, l, mid);
            a.r = merge(a.r, b.r, mid + 1, r);
            a.sum = (a.l != null ? a.l.sum : 0) + (a.r != null ? a.r.sum : 0);
            return a;
        }

        Node insert(Node root, int l, int r, int x) {
            if (root == null) {
                root = new Node();
            }
            if (l == r) {
                root.sum = 1;
                return root;
            }
            int mid = (l + r) >>> 1;
            if (x <= mid) {
                root.l = insert(root.l, l, mid, x);
            } else {
                root.r = insert(root.r, mid + 1, r, x);
            }
            root.sum = (root.l != null ? root.l.sum : 0) + (root.r != null ? root.r.sum : 0);
            return root;
        }

        int query(Node root, int l, int r, int k) {
            if (l == r) {
                return l;
            }
            int mid = (l + r) >>> 1;
            int leftSum = (root.l != null) ? root.l.sum : 0;
            if (leftSum >= k) {
                return query(root.l, l, mid, k);
            } else {
                return query(root.r, mid + 1, r, k - leftSum);
            }
        }
    }
}
/*
3590. 第 K 小的路径异或和
https://leetcode.cn/problems/kth-smallest-path-xor-sum/description/

第 159 场双周赛 T4。

给定一棵以节点 0 为根的无向树，带有 n 个节点，按 0 到 n - 1 编号。每个节点 i 有一个整数值 vals[i]，并且它的父节点通过 par[i] 给出。
从根节点 0 到节点 u 的 路径异或和 定义为从根节点到节点 u 的路径上所有节点 i 的 vals[i] 的按位异或，包括节点 u。
给定一个 2 维整数数组 queries，其中 queries[j] = [uj, kj]。对于每个查询，找到以 uj 为根的子树的所有节点中，第 kj 小 的 不同 路径异或和。如果子树中 不同 的异或路径和少于 kj，答案为 -1。
返回一个整数数组，其中第 j 个元素是第 j 个查询的答案。
在有根树中，节点 v 的子树包括 v 以及所有经过 v 到达根节点路径上的节点，即 v 及其后代节点。
提示：
1 <= n == vals.length <= 5 * 10^4
0 <= vals[i] <= 10^5
par.length == n
par[0] == -1
对于 [1, n - 1] 中的 i，0 <= par[i] < n
1 <= queries.length <= 5 * 10^4
queries[j] == [uj, kj]
0 <= uj < n
1 <= kj <= n
输出保证父数组 par 表示一棵合法的树。

离散化 + 树上启发式合并 + 树状数组 https://yuanbao.tencent.com/chat/naQivTmsDa/8b8744d9-0e6e-452e-8c89-518d0311cbe3
离散化 + 树上启发式合并 + 线段树上二分 https://chat.deepseek.com/a/chat/s/4793e242-c4c2-4336-94c7-013844b3c592
时间复杂度 O(n log^2 n)
rating 2608 (clist.by)
 */