import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionLCP69_2 {
    private static final int INF = Integer.MAX_VALUE / 2;
    private int n;
    private List<Map<Node, Integer>> costs;
    private List<Map<Node, Integer>> memo;

    public int Leetcode(String[] words) {
        n = words.length;

        // 预处理每个单词的每种选择字母的方案所消耗的代币的最小值
        costs = new ArrayList<>();
        for (String word : words) {
            Map<Node, Integer> costMap = new HashMap<>();
            dfs(word, new Node(new int[7]), 0, costMap);
            costs.add(costMap);
        }

        // 记忆化搜索
        memo = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            memo.add(new HashMap<>());
        }
        int res = dfs2(0, new Node(new int[7]));
        return res == INF ? -1 : res;
    }

    private int dfs2(int i, Node mask) {
        if (i == n) {
            // inf 表示不合法，没有选完要求的字母
            return mask.isFull() ? 0 : INF;
        }
        if (memo.get(i).containsKey(mask)) {
            return memo.get(i).get(mask);
        }
        int res = INF;
        for (Map.Entry<Node, Integer> entry : costs.get(i).entrySet()) {
            Node add = entry.getKey();
            int tot = entry.getValue();
            // 剪枝
            if (tot >= res) {
                continue;
            }
            Node m = merge(mask, add);
            if (m.isLess()) {
                res = Math.min(res, tot + dfs2(i + 1, m));
            }
        }
        if (!memo.get(i).containsKey(mask)) {
            memo.get(i).put(mask, res);
        }
        return res;
    }

    private void dfs(String str, Node mask, int tot, Map<Node, Integer> costMap) {
        if (!costMap.containsKey(mask) || costMap.get(mask) > tot) {
            costMap.put(mask, tot);
        }
        for (int k = 0; k < str.length(); k++) {
            char ch = str.charAt(k);
            String nextStr = str.substring(0, k) + str.substring(k + 1);
            int nextTot = tot + k * (str.length() - 1 - k);
            Node nextMask = new Node(mask.cnt);
            for (int i = 0; i < Node.N; i++) {
                // 可以选 ch
                if (ch == Node.CHARS[i] && nextMask.cnt[i] < Node.LIMIT[i]) {
                    nextMask.cnt[i]++;
                    dfs(nextStr, nextMask, nextTot, costMap);
                    break;
                }
            }
        }
    }

    // 合并两种选择字母的方案
    private Node merge(Node cur, Node add) {
        Node res = new Node(cur.cnt);
        for (int i = 0; i < Node.N; i++) {
            res.cnt[i] += add.cnt[i];
        }
        return res;
    }

    private static class Node {
        private static final int N = 7;
        private static final char[] CHARS = {'e', 'l', 'o', 'h', 't', 'c', 'd'};
        private static final int[] LIMIT = {4, 3, 2, 1, 1, 1, 1};
        private final int[] cnt;

        public Node(int[] tuple) {
            cnt = new int[N];
            System.arraycopy(tuple, 0, cnt, 0, N);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node node)) return false;
            return Arrays.equals(cnt, node.cnt);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(cnt);
        }

        boolean isFull() {
            return Arrays.equals(cnt, LIMIT);
        }

        boolean isLess() {
            for (int i = 0; i < N; i++) {
                if (cnt[i] > LIMIT[i]) {
                    return false;
                }
            }
            return true;
        }
    }
}
/*
思路同 SolutionLCP69.java
除了用一个整数表示所选择的状态外
还可以用多维数组，即 costs[][][][][][][]，缺点是轮询时要轮询所有元素，即 costs[][][][][][][] != -1
可以用自定义对象（7 个整数），即 int e, l, o, h, t, c, d; 缺点是无法轮询，需要写 else-if
还可以用自定义对象（数组），即本题解法。实战耗时优于 状态压缩 DP。
 */