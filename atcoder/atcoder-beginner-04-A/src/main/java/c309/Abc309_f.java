package c309;

import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Abc309_f {
    static int n;
    static int[][] hwd;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        hwd = new int[n][3];
        for (int i = 0; i < n; i++) {
            hwd[i][0] = scanner.nextInt();
            hwd[i][1] = scanner.nextInt();
            hwd[i][2] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    // https://atcoder.jp/contests/abc309/submissions/43408962
    private static String solve() {
        for (int[] cuboid : hwd) {
            Arrays.sort(cuboid);
        }
        Arrays.sort(hwd, (o1, o2) -> {
            for (int i = 0; i < 3; i++) {
                if (o1[i] != o2[i]) {
                    return Integer.compare(o1[i], o2[i]);
                }
            }
            return 0;
        });

        // O(n^2)
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < i; j++) {
//                // 排序后，cuboids[j][0] <= cuboids[i][0] 恒成立
//                if (hwd[j][0] < hwd[i][0]
//                        && hwd[j][1] < hwd[i][1]
//                        && hwd[j][2] < hwd[i][2]) {
//                    return "Yes";
//                }
//            }
//        }
//        return "No";

        DynamicSegTreeUpd seg = new DynamicSegTreeUpd();
        int lastH = 0;
        Deque<int[]> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int h = hwd[i][0];
            if (lastH < h) {
                while (!stack.isEmpty()) {
                    int[] hwd_ = stack.pop();
                    int w = hwd_[1];
                    int d = hwd_[2];
                    int min = Math.min(seg.getMin(w, w), d);
                    seg.update(w, w, min);
                }
            }

            int w = hwd[i][1];
            int d = hwd[i][2];
            if (seg.getMin(0, w - 1) < d) {
                return "Yes";
            }

            stack.push(hwd[i]);
            lastH = h;
        }

        return "No";
    }

    private static class DynamicSegTreeUpd {
        private static final int INF = Integer.MAX_VALUE;
        private static final int N = INF;
        private final Node root = new Node();

        private static class Node {
            Node ls, rs;
            int min = INF;
            int lazy;
        }

        // 区间 [l,r] 置为 val
        public void update(int l, int r, int val) {
            this.update(l, r, val, 0, N, root);
        }

        // 区间 [l,r] 最大值
        public int getMin(int l, int r) {
            return this.getMin(l, r, 0, N, root);
        }

        private void update(int l, int r, int val, int s, int t, Node node) {
            if (l <= s && t <= r) {
                node.min = val;
                node.lazy = val;
                return;
            }
            int mid = s + (t - s) / 2;
            pushDown(node);
            if (l <= mid) {
                update(l, r, val, s, mid, node.ls);
            }
            if (r > mid) {
                update(l, r, val, mid + 1, t, node.rs);
            }
            pushUp(node);
        }

        private int getMin(int l, int r, int s, int t, Node node) {
            if (l <= s && t <= r) {
                return node.min;
            }
            int mid = s + (t - s) / 2;
            pushDown(node);
            int min = INF;
            if (l <= mid) {
                min = getMin(l, r, s, mid, node.ls);
            }
            if (r > mid) {
                min = Math.min(min, getMin(l, r, mid + 1, t, node.rs));
            }
            return min;
        }

        private void pushDown(Node node) {
            if (node.ls == null) {
                node.ls = new Node();
            }
            if (node.rs == null) {
                node.rs = new Node();
            }
            if (node.lazy > 0) {
                node.ls.min = node.lazy;
                node.rs.min = node.lazy;
                node.ls.lazy = node.lazy;
                node.rs.lazy = node.lazy;
                node.lazy = 0;
            }
        }

        private void pushUp(Node node) {
            node.min = Math.min(node.ls.min, node.rs.min);
        }
    }
}
/*
F - Box in Box
https://atcoder.jp/contests/abc309/tasks/abc309_f

灵茶の试炼 2023-09-07
题目大意：
有 N 个盒子。第 i 个盒子的形状为长方体，其高为 hi，宽为 wi，深为 di。
确定是否有两个盒子，其中一个的高度、宽度和深度在必要时旋转后严格大于另一个。

三维 偏序问题
相似题目: 1691. 堆叠长方体的最大高度
https://leetcode.cn/problems/maximum-height-by-stacking-cuboids/
======

Input 1
3
19 8 22
10 24 12
15 25 11
Output 1
Yes

Input 2
3
19 8 22
10 25 12
15 24 11
Output 2
No

Input 3
2
1 1 2
1 2 2
Output 3
No
 */