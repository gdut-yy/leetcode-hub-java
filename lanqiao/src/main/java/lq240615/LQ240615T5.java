package lq240615;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LQ240615T5 {
    static int n, q;
    static int[] a, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        q = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        b = new int[q];
        for (int i = 0; i < q; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static final int MOD = 998244353;

    private static String solve() {
        int[] cnt = new int[n];
        for (int v : a) {
            cnt[v]++;
        }

        long[] pre = new long[n + 1];
        for (int i = 0; i < n; i++) {
            if (cnt[i] != 0) {
                pre[i] = quickPow(2, cnt[i]) - 1;
                if (pre[i] < 0) pre[i] += MOD;
            }
            if (i - 1 >= 0) {
                pre[i] = pre[i] * pre[i - 1] % MOD;
            }
        }
        long[] suf = new long[n + 1];
        Arrays.fill(suf, 1);
        for (int i = n - 1; i >= 0; i--) {
            suf[i] = quickPow(2, cnt[i]);
            if (i + 1 < n) {
                suf[i] = suf[i] * suf[i + 1] % MOD;
            }
        }

        long[] ans = new long[q];
        for (int i = 0; i < q; i++) {
            int k = b[i];
            if (k == 0) {
                ans[i] = suf[1] - 1;
            } else if (k == n) {
                ans[i] = pre[n - 1];
            } else {
                ans[i] = pre[k - 1] * suf[k + 1] % MOD;
            }
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
    }

    static long quickPow(long a, long b) {
        long res = 1L;
        while (b > 0) {
            if ((b & 1) != 0) res = res * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }
}
/*
小蓝的 MEX 问题【算法赛】

当查询为 k 时，我们分两个区间考虑：
- 对于区间[0, k-1]，这里面的数必须最少出现一次，若某个数出现次数为 0 则答案为 0。否则对于区间内任意某个数，设其出现次数为 x，由于这 æ 个数有可选和可不选方案，并且必须保证最少选一个，则该数的可选方案有 2^x-1。
- 对于区间[k+1, n-1]，对于区间内任意某个数，设其出现次数为 x，由于这 x 个数有可选和可不选方案，则该数的可选方案有 2^x，
我们只需要将所有数的可选方案乘起来即可得到答案。
由于存在多次查询，我们不能每次都以 O(n) 的复杂度去解决每次询问。由于每次都是选择一个前缀区间和一个后缀区间，我们进行前后缀分解预处理即可，这样每次查询解决的复杂度为 O(1)。
 */