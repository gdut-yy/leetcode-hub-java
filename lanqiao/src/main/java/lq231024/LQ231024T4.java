package lq231024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class LQ231024T4 {
    static int n, p;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        p = scanner.nextInt();

        g = new ArrayList[n + 1];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 1; i <= n; i++) {
            int f = scanner.nextInt();
            int s = scanner.nextInt();
            int k = scanner.nextInt();
            // f->i
            g[f].add(new int[]{i, s, k});
        }
        System.out.println(solve());
    }

    static List<int[]>[] g;

    private static String solve() {
        // i,s,k
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        minHeap.addAll(g[0]);
        long exp = p;
        int ans = 0;
        while (!minHeap.isEmpty()) {
            int[] tuple = minHeap.remove();
            int y = tuple[0], s = tuple[1], k = tuple[2];
            if (exp >= k) {
                exp += s;
                minHeap.addAll(g[y]);
                ans++;
            }
        }
        return String.valueOf(ans);
    }
}
/*
通关【算法赛】

优先队列。
 */