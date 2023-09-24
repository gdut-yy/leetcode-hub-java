package codefestival2016;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Codefestival_2016_qualC_c {
    static int n;
    static int[] b, c;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        c = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static final int MOD = (int) (1e9 + 7);

    private static String solve() {
        long ans = 1;
        for (int i = 0; i < n; i++) {
            boolean fixB = i == 0 || b[i] > b[i - 1];
            boolean fixC = i == n - 1 || c[i] > c[i + 1];
            if (fixB && b[i] > c[i] || fixC && b[i] < c[i]) {
                return "0";
            }
            if (!fixB && !fixC) {
                ans = ans * Math.min(b[i], c[i]) % MOD;
            }
        }
        return String.valueOf(ans);
    }
}
/*
C - Two Alpinists
https://atcoder.jp/contests/code-festival-2016-qualc/tasks/codefestival_2016_qualC_c

灵茶の试炼 2023-09-13
题目大意：
输入 n(1≤n≤1e5) 和两个长为 n 的数组 b 和 c (1≤b[i],c[i]≤1e9)。
构造数组 a，满足 a[i] 都是正整数，且：
b[i] = max(a[0], a[1], ..., a[i])，即数组 a 的前缀最大值。
c[i] = max(a[i], a[i+1], ..., a[n-1])，即数组 a 的后缀最大值。
问：有多少个符合要求的数组 a？模 1e9+7。
如果不存在这样的数组 a，输出 0。

如果 b[i]>b[i-1]，那么 a[i] 一定是 b[i]。如果此时 c[i] < b[i]，矛盾，输出 0。
同理，如果 c[i]>c[i+1]，那么 a[i] 一定是 c[i]。如果此时 b[i] < c[i]，矛盾，输出 0。
如果 b[i]=b[i-1] 且 c[i]=c[i+1]，那么 a[i] 可以填不超过 min(b[i],c[i]) 的正整数，这有 min(b[i],c[i]) 种方案。
所有 a[i] 的方案数相乘即为答案。
https://atcoder.jp/contests/code-festival-2016-qualc/submissions/45329380
======

Input 1
5
1 3 3 3 3
3 3 2 2 2
Output 1
4

Input 2
5
1 1 1 2 2
3 2 1 1 1
Output 2
0

Input 3
10
1 3776 3776 8848 8848 8848 8848 8848 8848 8848
8848 8848 8848 8848 8848 8848 8848 8848 3776 5
Output 3
884111967

Input 4
1
17
17
Output 4
1
 */