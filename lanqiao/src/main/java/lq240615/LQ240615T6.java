package lq240615;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LQ240615T6 {
    static int n, q;
    static int[] c;
    static int[][] km;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        q = scanner.nextInt();
        c = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = scanner.nextInt();
        }
        km = new int[q][2];
        for (int i = 0; i < q; i++) {
            km[i][0] = scanner.nextInt();
            km[i][1] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    static long[] ps;

    private static String solve() {
        Arrays.sort(c);
        ps = new long[n + 1];
        for (int i = 0; i < n; i++) {
            ps[i + 1] = ps[i] + c[i];
        }

        long[] ans = new long[q];
        for (int i = 0; i < q; i++) {
            int x = km[i][0], y = km[i][1];
            ans[i] = getAns(x, y);
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
    }

    static long getAns(int x, int y) {
        int l = 0, r = y;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (checkMid(x, y, mid)) r = mid;
            else l = mid + 1;
        }
        return ps[l] + 2L * x * (y - l) - (ps[n] - ps[n - y + l]);
    }

    static boolean checkMid(int x, int y, int mid) {
        if (c[mid] > x) return true;
        if (c[n - y + mid] <= x) return false;
        if (get(mid, x) < get(n - y + mid, x)) return false;
        return true;
    }

    static long get(int pos, int x) {
        if (c[pos] > x) return x * 2L - c[pos];
        return c[pos];
    }
}
/*
平摊购买费用【算法赛】

首先，我们观察到绘画作品的顺序并不重要，因此我们可以对它们进行排序，以便后续的操作。
对于一个绘画作品：
- 如果给画作品的价格小于 k，小蓝将支付全价，因此她会选择价格最小的给画作品。
- 如果绘画作品的价格大于 k，那么其对 l-f 的贡献将等于 k-(c-k)=2k-c。因此，给画作品越贵越好
有了这些信息，我们就可以将绘画作品分为两类（c≤k 和 c>k）。
如果小蓝选择了 x 个价格小于 k 的绘画作品，m-x 个价格大于 k 的绘画作品，那么这 x 个必定是排序后的前 x 个作品，m-x 必定是排序后的后 m-x 个作品。
---
如何调整 x 的取值让答案尽可能优呢？我们来分析一下。
如果 x 的值減少 1，那么小蓝会少选一个价格小于 k 绘画作品（l-f 的值会減少 cx），多送一个价格大于 k 的绘画作品（l-f 的值会增加 2k - c_{m-z}）。若 cx 的值大于 c_{m-z}，则让 x 的值减少是更优选择。而随着 x 的减少，cx 对 l-f 的贡献将越来越少，2k - c_{m-z} 对答案的贡献将越来越大。
因此，其满足单调性，对于每个查询，我们可以对进行二分，来确认它的取值，并完成解题。
总时间复杂度为 O(qlogn)。
 */