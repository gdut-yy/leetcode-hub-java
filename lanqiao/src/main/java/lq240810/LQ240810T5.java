package lq240810;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class LQ240810T5 {
    static int n;
    static Fairy[] fairy;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        fairy = new Fairy[n + 2];
        Arrays.setAll(fairy, e -> new Fairy());
        for (int i = 1; i <= n; i++) fairy[i].p = scanner.nextInt();
        for (int i = 1; i <= n; i++) fairy[i].a = scanner.nextInt();
        System.out.println(solve());
    }

    static final int INF = (int) 2e9;

    private static String solve() {
        fairy[0].p = -INF;
        fairy[n + 1].p = INF;
        Arrays.sort(fairy, Comparator.comparingInt(w -> w.p));

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (fairy[i - 1].p < fairy[i].p - fairy[i].a && fairy[i].p + fairy[i].a < fairy[i + 1].p) {
                ans++;
            }
        }
        return String.valueOf(ans);
    }

    static class Fairy { // 仙女
        int p, a; // 坐标, 安全距离
    }

    static class V2 {
        static int n;
        static int[] p, a;

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            n = scanner.nextInt();
            p = new int[n + 2];
            a = new int[n + 2];
            for (int i = 1; i <= n; i++) p[i] = scanner.nextInt();
            for (int i = 1; i <= n; i++) a[i] = scanner.nextInt();
            System.out.println(solve());
        }

        static final int INF = (int) 2e9;

        private static String solve() {
            p[0] = -INF;
            p[n + 1] = INF;

            Integer[] ids = new Integer[n + 2];
            for (int i = 0; i < n + 2; i++) ids[i] = i;
            Arrays.sort(ids, Comparator.comparingInt(o -> p[o]));

            int ans = 0;
            for (int j = 1; j <= n; j++) {
                int i = ids[j];
                int li = ids[j - 1], ri = ids[j + 1];
                if (p[li] < p[i] - a[i] && p[i] + a[i] < p[ri]) {
                    ans++;
                }
            }
            return String.valueOf(ans);
        }
    }
}
/*
仙男仙女【算法赛】

用下标数组的话比较麻烦。
 */