package lq240810;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LQ240810T6 {
    static int n;
    static List<Integer>[] g;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        g = new ArrayList[n];
        d1 = new int[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 0; i < n - 1; i++) {
            int u = scanner.nextInt() - 1;
            int v = scanner.nextInt() - 1;
            g[u].add(v);
            g[v].add(u);
            d1[u]++;
            d1[v]++;
        }
        System.out.println(solve());
    }

    static int[] d1; // 距离为 1 的点数

    private static String solve() {
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = -d1[i];
            for (Integer v : g[i]) {
                ans[i] += d1[v];
            }
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
牛郎的微信群【算法赛】

注意不是树形 DP
 */