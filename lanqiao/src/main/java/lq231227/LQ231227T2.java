package lq231227;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LQ231227T2 {
    static int n;
    static char[] s;
    static List<Integer>[] g;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            s = scanner.next().toCharArray();
            g = new ArrayList[n];
            Arrays.setAll(g, e -> new ArrayList<>());
            for (int i = 1; i < n; i++) {
                int x = scanner.nextInt() - 1;
                int y = scanner.nextInt() - 1;
                g[x].add(y);
                g[y].add(x);
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        sz = new int[n];
        Arrays.fill(sz, 1);
        dfs(0, -1);
        return Arrays.stream(sz).max().orElseThrow() < 3 ? "YES" : "NO";
    }

    static int[] sz;

    static void dfs(int x, int fa) {
        for (int y : g[x]) {
            if (y != fa) {
                dfs(y, x);
                if (s[x] == s[y]) {
                    sz[x] += sz[y];
                }
            }
        }
    }
}
/*
蓝桥圣诞树【算法赛】

树形 DP。
 */