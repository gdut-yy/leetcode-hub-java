package p1920;

import java.util.Scanner;

public class CF1920C {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    static int ans;

    private static String solve() {
        ans = 0;
        for (int d = 1; d * d <= n; d++) {
            if (n % d == 0) {
                f(d);
                if (d * d < n) {
                    f(n / d);
                }
            }
        }
        return String.valueOf(ans);
    }

    static void f(int d) {
        int g = 0;
        for (int i = 0; i < d; i++) {
            for (int j = i + d; j < n; j += d) {
                g = getGCD(g, a[j] - a[j - d]);
            }
        }
        if (g != 1 && g != -1) {
            ans++;
        }
    }

    static int getGCD(int num1, int num2) {
        return num1 == 0 ? num2 : getGCD(num2 % num1, num1);
    }
}
/*
C. Partitioning the Array
https://codeforces.com/contest/1920/problem/C

灵茶の试炼 2024-11-19
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) 和长为 n 的数组 a(1≤a[i]≤n)。
枚举 n 的所有因子 k，做如下计算：
把 a 分成 n/k 段，每段长度均为 k。
如果存在一个 >=2 的整数 m，使得所有 a[i]%=m 后，这 n/k 个段都相同，那么得分加一。
比如 [1,6,3,5,6,7] 在 k=3,m=4 的时候，可以得到两个一样的段 [1,2,3],[1,2,3]。
输出总得分。
注意每个 k 只能算一次得分。即对于同一个 k，如果有多个 m 满足要求，也只计入 1 分。

rating 1600
题目要求 m 必须 >= 2，不妨计算最大的 m。
如果所有数组都能变成一样的，说明余数 r = a[i] - x*m = a[i+k] - y*m，即 a[i+k] - a[i] 是 m 的倍数。
那么求序列 a[i],a[i+k],a[i+2k],... 中的所有相邻元素的绝对差的 GCD，记作 g(i)。
计算 g(0),g(1),...,g(k-1) 的 GCD，如果 >= 2，那么答案加一。
下面代码没有算绝对差，而是保证最终 abs(GCD) != 1 即可。
代码 https://codeforces.com/problemset/submission/1920/290184469
代码备份（洛谷）
======

Input
8
4
1 2 1 4
3
1 2 3
5
1 1 1 1 1
6
1 3 1 1 3 1
6
6 2 6 2 2 2
6
2 6 3 6 6 6
10
1 7 5 1 4 3 1 3 1 4
1
1
Output
2
1
2
4
4
1
2
1
 */
