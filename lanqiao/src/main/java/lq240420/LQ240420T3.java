package lq240420;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class LQ240420T3 {
    static int n, k;
    static long[] xs, ys;
    static int x, y;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            k = scanner.nextInt();
            xs = new long[n - 1];
            ys = new long[n - 1];
            for (int i = 0; i < n - 1; i++) {
                xs[i] = scanner.nextInt();
                ys[i] = scanner.nextInt();
            }
            x = scanner.nextInt();
            y = scanner.nextInt();
            System.out.println(solve());
        }
    }

    private static String solve() {
        long ans = Long.MAX_VALUE;
        if (k >= n) {
            ans = (k - n) * Math.min(Arrays.stream(ys).min().orElseThrow(), y)
                    + Arrays.stream(xs).sum() + x;
        }

        n--;
        Integer[] sorted_range = new Integer[n];
        for (int i = 0; i < n; i++) sorted_range[i] = i;
        Arrays.sort(sorted_range, Comparator.comparingLong(o -> xs[o]));
        long[] xs_tmp = new long[n];
        long[] ys_tmp = new long[n];
        for (int i = 0; i < n; i++) {
            xs_tmp[i] = xs[sorted_range[i]];
            ys_tmp[i] = ys[sorted_range[i]];
        }
        xs = xs_tmp;
        ys = ys_tmp;

        long[] xs_acc = new long[n + 1];
        for (int i = 0; i < n; i++) {
            xs_acc[i + 1] = xs_acc[i] + xs[i];
        }

        for (int i = 0; i < n; i++) {
            int p = Math.min(k, upperBound(xs, ys[i]));
            if (i < p) {
                ans = Math.min(ans, xs_acc[p] + ys[i] * (k - p));
            } else {
                p = Math.min(p, k - 1);
                ans = Math.min(ans, xs_acc[p] + xs[i] + ys[i] * (k - p - 1));
            }
        }
        return String.valueOf(ans);
    }

    static int upperBound(long[] a, long key) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a[m] > key) r = m;
            else l = m + 1;
        }
        return l;
    }
}
/*
兽之泪 II【算法赛】

考察贪心，分情况讨论。
如果必须攻击最后一个怪兽，那么所有的 x 都需要攻击一遍。
在剩下的次数中选择最小的 y 进行攻击即可。
如果不选择攻击最后一个怪兽。
那么需要注意到一个事实，如果攻击某一个怪兽的 y，那么一定是只攻击这一个怪兽的 y 是最优的。
应该如果选择了两只怪兽 i, j，并且花费了 yi + yj，那么显然是不如 2 * min(yi, yi) 更优。
所以我们只需要枚举某一只怪兽，我们只攻击他的 y 即可。
那么为了答案更优，我们只需要选择比这只怪兽的 y 小的 x 进行攻击即可。
我们针对 x 进行排序后，然后枚举 y，然后二分查找出最大的 x，前缀和维护答案即可。
时间复杂度：O(nlogn)
@小羊肖恩Yawn_Sean
 */