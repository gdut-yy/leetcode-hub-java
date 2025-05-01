package p150;

import java.util.Scanner;

public class CF150B {
    static int n, m, k;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();
        System.out.println(solve());
    }

    private static final int MOD = (int) (1e9 + 7);

    private static String solve() {
        long ans;
        if (k == 1 || k > n) {
            ans = quickPow(m, n);
        } else if (k == n) {
            ans = quickPow(m, (n + 1) / 2);
        } else if (k % 2 == 0) {
            ans = m;
        } else {
            ans = (long) m * m;
        }
        return String.valueOf(ans);
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
B. Quantity of Strings
https://codeforces.com/contest/150/problem/B

灵茶の试炼 2025-03-12
题目大意：
输入 n m k(1≤n,m,k≤2000)。
输出有多少个长为 n 的字符串 s，满足 s 中的每个长为 k 的连续子串都是回文串。
其中 m 为字母表的大小。
答案模 1e9+7。
进阶：做到 O(log n)。

rating 1600
分类讨论：
如果 k=1 或者 k>n，随便填，答案为 pow(m, n)。
如果 k=n，左半随便填（包含回文中心），答案为 pow(m, (n+1)/2)。
如果 k 是偶数，对比第一个长为 k 的回文串和第二个长为 k 的回文串，看看哪些位置必须相同，可以发现所有字母都必须是一样的，答案为 m。
如果 k 是奇数，同样地，可以发现奇数位置都必须一样，偶数位置都必须一样，二者互相独立，所以答案为 m*m。
代码 https://codeforces.com/contest/150/submission/309562053
代码备份（洛谷）
======

Input
1 1 1
Output
1

Input
5 2 4
Output
2
 */
