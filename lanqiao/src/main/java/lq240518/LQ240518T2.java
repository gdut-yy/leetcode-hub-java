package lq240518;

import java.util.Arrays;
import java.util.Scanner;

public class LQ240518T2 {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static final int MOD = 998244353;

    private static String solve() {
        Arrays.sort(a);
        long ans = 0;
        for (int v : a) {
            ans = (ans * 10 + v) % MOD;
        }
        return String.valueOf(ans);
    }
}
/*
最小值取余【算法赛】

假设我们第 i  次选择了 c，显然之后每次选择一个数，c 的值都会变大 10 倍，所以 c 的最终值为 10^{n-i} * c。
最终得到 x 的值为：
x = \sum_{i=1}^{n} a_i \times 10^{n-i}
为了使得 x 最小，显然我们应该优先选择 a 中较小的数，对 a 进行排序后求解即可。
 */