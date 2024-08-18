package lq240420;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class LQ240420T6 {
    static int n, k;
    static List<int[]>[] path;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            n = scanner.nextInt();
            k = scanner.nextInt();
            path = new ArrayList[n];
            Arrays.setAll(path, e -> new ArrayList<>());
            for (int i = 0; i < n - 1; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;
                int w = scanner.nextInt();
                path[u].add(new int[]{v, w});
                path[v].add(new int[]{u, w});
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        int[] parent = new int[n];
        long[] parent_weight = new long[n];
        Arrays.fill(parent, -1);
        Arrays.fill(parent_weight, -1);
        List<Integer> order = new ArrayList<>();

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        while (!stack.isEmpty()) {
            int u = stack.pop();
            for (int[] p : path[u]) {
                int v = p[0], w = p[1];
                if (parent[u] != v) {
                    parent[v] = u;
                    parent_weight[v] = w;
                    stack.push(v);
                    order.add(v);
                }
            }
        }

        int[] size = new int[n];
        Arrays.fill(size, 1);
        for (int i = order.size() - 1; i >= 0; i--) {
            int j = order.get(i);
            size[parent[j]] += size[j];
        }

        long ans = 0;
        for (int i = 1; i < n; i++) {
            ans += size[i] * parent_weight[i];
        }

        PriorityQueue<long[]> hpq = new PriorityQueue<>(Comparator.comparingLong(o -> o[0]));
        for (int i = 1; i < n; i++) {
            if (parent_weight[i] > 1) {
                hpq.add(new long[]{-(parent_weight[i] / 2 * size[i]), i});
            }
        }

        while (!hpq.isEmpty() && k > 0) {
            long[] top = hpq.remove();
            long x = top[0];
            int i = (int) top[1];

            ans += x;
            parent_weight[i] -= parent_weight[i] / 2;
            if (parent_weight[i] > 1) {
                hpq.add(new long[]{-(parent_weight[i] / 2 * size[i]), i});
            }
            k -= 1;
        }

        return String.valueOf(ans);
    }
}
/*
修整道路【算法赛】

本题考察贪心，数据结构，图
可能有同学会认为是树形 DP，但是复杂度太大，无法通过本题。
本题需要转换思路，将边看作主体，我们将 1 作为根，然后算出每条边会被使用多少次，也就是每条边有多少个子孙节点。
假设对于第 i 条边，使用了 ci 次，那么会计算在答案中的贡献就是 wi * ci。
所以如果对该边进行修整，那么答案就会减少 ci * wi / 2，所以，我们可以用优先队列进行逐次整修。
时间复杂度 O(nlognlogw)。
@小羊肖恩Yawn_Sean
 */