package p1980;

import java.util.Scanner;

public class CF1980D {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new int[n + 5];
            for (int i = 3; i <= n + 2; i++) {
                a[i] = scanner.nextInt();
            }
            a[2] = 1;
            a[n + 4] = a[n + 1];
            System.out.println(solve());
        }
    }

    private static String solve() {
        int end = n + 1;
        for (int i = n; i > 3 && getGCD(a[i], a[i + 1]) <= getGCD(a[i + 1], a[i + 2]); i--) {
            end = i;
        }
        for (int i = 3; i <= n + 2 && getGCD(a[i - 3], a[i - 2]) <= getGCD(a[i - 2], a[i - 1]); i++) {
            int g = getGCD(a[i - 1], a[i + 1]);
            if (i + 1 >= end && getGCD(a[i - 2], a[i - 1]) <= g && g <= getGCD(a[i + 1], a[i + 2])) {
                return "YES";
            }
        }
        return "NO";
    }

    static int getGCD(int num1, int num2) {
        return num1 == 0 ? num2 : getGCD(num2 % num1, num1);
    }
}
/*
D. GCD-sequence
https://codeforces.com/contest/1980/problem/D

灵茶の试炼 2024-12-09
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(3≤n≤2e5) 和长为 n 的数组 a(1≤a[i]≤1e9)。
你需要从 a 中恰好删除一个数，得到长为 n-1 的数组 a'。
然后生成一个长为 n-2 的数组 b，其中 b[i] = GCD(a'[i],a'[i+1])。
你需要让数组 b 是非降序列，即 b[i] <= b[i+1]。
能否做到？输出 YES 或 NO。

rating 1400
pairwise 版本的前后缀分解。
删除 a[i] 会把 b[i-1] 变成 GCD(a[i-1],a[i+1])，同时移除 b[i]。
如果 b[0] 到 b[i-2] 是非降的，且 b[i+1] 到 b[n-3] 是非降的，且 b[i-2] <= GCD(a[i-1],a[i+1]) <= b[i+1]，那么输出 YES。
实现时，可以在 a 前后添加若干哨兵，从而简化代码逻辑，具体见代码。
代码 https://codeforces.com/problemset/submission/1980/295818732
代码备份（洛谷）
======

Input
12
6
20 6 12 3 48 36
4
12 6 3 4
3
10 12 3
5
32 16 8 4 2
5
100 50 2 10 20
4
2 4 8 1
10
7 4 6 2 4 5 1 4 2 8
7
5 9 6 8 5 9 2
6
11 14 8 12 9 3
9
5 7 3 10 6 3 12 6 3
3
4 2 4
8
1 6 11 12 6 12 3 6
Output
YES
NO
YES
NO
YES
YES
NO
YES
YES
YES
YES
YES
 */
