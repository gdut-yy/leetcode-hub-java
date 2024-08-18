package lq240615;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LQ240615T8 {
    static int n, k;
    static int[] h;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        h = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        List<long[]> r = new ArrayList<>();

        long res = 0;
        int N = (int) (1e6 + 10);
        long[] s = new long[N];
        for (int i = 0; i < n; i++) {
            int x = h[i];

            s[i] = (i > 0 ? s[i - 1] : 0) + x;
            for (long[] tmp : r) {
                tmp[1] = getGCD(tmp[1], x);
            }

            r.add(new long[]{i, x});
            List<long[]> unique = new ArrayList<>();

            for (int j = 0; j < r.size(); j++) {
                if (j == 0 || r.get(j - 1)[1] != r.get(j)[1]) {
                    unique.add(r.get(j));
                }
            }
            r = unique;
            for (long[] tmp : r) {
                if (i - tmp[0] + 1 >= k) {
                    res = Math.max(res, tmp[1] * (s[i] - (tmp[0] != 0 ? s[(int) (tmp[0] - 1)] : 0)));
                }
            }
        }
        return String.valueOf(res);
    }

    static long getGCD(long num1, long num2) {
        return num1 == 0 ? num2 : getGCD(num2 % num1, num1);
    }
}
/*
价值共性度【算法赛】

对于区间 [l,r]，其最大公约数可以表示为 G(l,r)，对于区间 [l+1,r]，其最大公约数可以表示为 G(l+1,r)。
根据最大公约数的性质，可得 G(l,r)、G(l+1,r) 必然满足以下两个关系之一：
1、G(l,r) = G(l+1,r)。
2、G(l,r) | G(l+1,r)，即 2 * G(l,r) <= G(l+1,r)。
因此，当我们将右边界 r 固定时，从左边界 l 到 r 之间的最大公约数 G(l,r) 的值是有限的，因为每次从 G(l,r)
到 G(l+1,r) 至少会翻倍一次，所以最多只能有 log(MAX) 种不同的值，其中 MAX 是数组中的最大元素。
于是，我们就可以从 1~n 枚举 r，并维护在当前边界 r 下每个可能的 G 值所达到的最左边的 l。
对于值相同的 G(l,r)，l 越小意味着区间长度越大，区间长度越大意味着区间和 S 越大，在最大公约数 G 相同时，
S 越大，答案就越大。
由于每个 r 对应的 G 最多只有 O(logMAX) 个，所以我们可以遍历所有这些值并计算出对应的美丽值。
时间复杂度为 O(n logMAX ln MAX)。
 */