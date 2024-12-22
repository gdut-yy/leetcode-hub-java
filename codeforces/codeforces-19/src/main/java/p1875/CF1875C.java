package p1875;

import java.util.Scanner;

public class CF1875C {
    static int n, m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            System.out.println(solve());
        }
    }

    private static String solve() {
        n %= m;
        int g = getGCD(n, m);
        n /= g;
        m /= g;
        if ((m & (m - 1)) > 0) {
            return "-1";
        }
        long ans = 0;
        while (n > 0) {
            ans += n;
            n = n * 2 % m;
        }
        return String.valueOf(ans * g);
    }

    static int getGCD(int num1, int num2) {
        return num1 == 0 ? num2 : getGCD(num2 % num1, num1);
    }
}
/*
C. Jellyfish and Green Apple
https://codeforces.com/contest/1875/problem/C

灵茶の试炼 2024-08-20
题目大意：
输入 T(≤2e4) 表示 T 组数据。
每组数据输入 n(1≤n≤1e9) 和 m(1≤m≤1e9)。
你有 n 个一样的苹果，要均分给 m 个小朋友，每个小朋友分到的量必须是一样的。
每次操作，你可以把一个苹果切开，得到两个一样的苹果块；或者，把一个苹果块一分为二，得到两个更小的苹果块。
你最少要操作多少次？如果无法做到，输出 -1。

rating 1400
如果 n >= m，可以先分给每人 floor(n/m) 个苹果。
下面讨论 n < m 的情况。
由于苹果块的重量是从 1 开始不断减半的，所以每个人分到的苹果重量的既约分数的分母一定是 2 的幂。如果不是，直接输出 -1。
例如把 15 个苹果分给 20 个人，和把 3 个苹果分给 4 个人是类似的。
计算出把 3 个苹果分给 4 个人的答案，再乘以 5，就得到了把 15 个苹果分给 20 个人的答案。
因此，如果 gcd(n,m) > 1，可以先把 n 和 m 都除以 gcd，最后把答案再乘以 gcd。
下面假设 gcd(n,m)=1 且 m=2^k。
把 3 个苹果分给 4 个人，我们可以先把每个苹果切一刀，得到 6 个 1/2 苹果。
接下来切苹果的次数，等价于：把 6 个苹果分给 4 个人的最少切苹果次数。
这和原问题是一样的，可以用递归/迭代解决。
具体来说：只要 n > 0 就不断循环，每次把 n 加到答案中，然后更新 n 为 n * 2 % m。
代码 https://codeforces.com/problemset/submission/1875/276914206
======

Input
4
10 5
1 5
10 4
3 4
Output
0
-1
2
5
 */
