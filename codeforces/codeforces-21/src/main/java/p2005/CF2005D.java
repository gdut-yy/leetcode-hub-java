package p2005;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF2005D {
    static int n;
    static int[][] a; // x, y

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new int[n][2];
            for (int i = 0; i < n; i++) {
                a[i][0] = scanner.nextInt();
            }
            for (int i = 0; i < n; i++) {
                a[i][1] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    //    record result(int g1, int g2, long l){
    //    }
    static class result {
        int g1, g2;
        long l;

        public result(int g1, int g2, long l) {
            this.g1 = g1;
            this.g2 = g2;
            this.l = l;
        }
    }

    private static String solve() {
        int[][] suf = new int[n + 1][2];
        for (int i = n - 1; i >= 0; i--) {
            suf[i][0] = getGCD(suf[i + 1][0], a[i][0]);
            suf[i][1] = getGCD(suf[i + 1][1], a[i][1]);
        }

        int mx = 0;
        long cnt = 0;
        int[] pre = new int[2];
        List<result> res = new ArrayList<>(); // g1, g2, l
        for (int i = 0; i < n; i++) {
            int[] v = a[i];
            for (result p : res) {
                p.g1 = getGCD(p.g1, v[1]);
                p.g2 = getGCD(p.g2, v[0]);
            }
            res.add(new result(getGCD(pre[0], v[1]), getGCD(pre[1], v[0]), i));
            int j = 1;
            for (int k = 1; k < res.size(); k++) {
                if (res.get(k).g1 != res.get(k - 1).g1 || res.get(k).g2 != res.get(k - 1).g2) {
                    res.set(j, res.get(k));
                    j++;
                }
            }
            // res = res[:j]
            res.subList(j, res.size()).clear();

            long prePos = i + 1;
            for (int k = res.size() - 1; k >= 0; k--) {
                result p = res.get(k);
                int s = getGCD(p.g1, suf[i + 1][0]) + getGCD(p.g2, suf[i + 1][1]);
                if (s > mx) {
                    mx = s;
                    cnt = prePos - p.l;
                } else if (s == mx) {
                    cnt += prePos - p.l;
                }
                prePos = p.l;
            }

            pre[0] = getGCD(pre[0], v[0]);
            pre[1] = getGCD(pre[1], v[1]);
        }
        return mx + " " + cnt;
    }

    static int getGCD(int num1, int num2) {
        return num1 == 0 ? num2 : getGCD(num2 % num1, num1);
    }
}
/*
D. Alter the GCD
https://codeforces.com/contest/2005/problem/D

灵茶の试炼 2024-11-08
题目大意：
输入 T(≤1e5) 表示 T 组数据。所有数据的 n 之和 ≤5e5。
每组数据输入 n(1≤n≤2e5)，长为 n 的数组 a(1≤a[i]≤1e9) 和长为 n 的数组 b(1≤b[i]≤1e9)。
你必须执行如下操作恰好一次：
选择两个下标 L 和 R，满足 L <= R。然后交换 a[L] 和 b[L]，交换 a[L+1] 和 b[L+1]，……，交换 a[R] 和 b[R]。
定义 GCD(A) 为数组 A 中所有元素的 GCD。
输出操作后 GCD(a) + GCD(b) 的最大值，以及有多少个不同的 (L,R) 可以得到这个最大值。

rating 2400
前后缀分解 + logTrick。
下标从 0 开始。
以 r 为分割线，计算 a 从 r+1 到 n-1 的后缀 GCD，以及 b 从 r+1 到 n-1 的后缀 GCD。
对于前缀 0 到 r，我们需要计算的是
GCD(a[0],a[1],...,a[l-1],b[l],b[l+1],...,b[r])
GCD(b[0],b[1],...,b[l-1],a[l],a[l+1],...,a[r])
这可以用 logTrick 计算（维护）。
定义 res(i) 是一个由 tuple 组成的列表，每个 tuple 包含三个数：
g1 = GCD(a[0],a[1],...,a[l-1],b[l],b[l+1],...,b[i])
g2 = GCD(b[0],b[1],...,b[l-1],a[l],a[l+1],...,a[i])
index = 在遍历 a,b 的过程中，这对 (g1,g2) 首次出现的下标。
从 i-1 遍历到 i，我们可以在 res(i-1) 的 g1 的基础上，额外 GCD 一个 b[i]，得到 res(i) 的 g1。
同理，在 res(i-1) 的 g2 的基础上，额外 GCD 一个 a[i]，得到 res(i) 的 g2。
然后额外增加一个只交换 a[i] 和 b[i] 的结果，即
g1 = GCD(a[0],a[1],...,a[i-1],b[i])
g2 = GCD(b[0],b[1],...,b[i-1],a[i])
以及这对 (g1,g2) 首次出现的下标，也就是 i。
为了计算这个额外增加的 (g1,g2)，我们还需要维护 a 和 b 的前缀 GCD。
对于每个 r，遍历所有的 res(r)，计算 GCD(a) + GCD(b) 的最大值。
出现次数可以用 res(i) 中的两个相邻 tuple 中的 index 之差得到。
注意这个算法就是纯纯的暴力，没有任何贪心策略。我们枚举了所有的可能，并通过 logTrick 减少了枚举的次数。
代码 https://codeforces.com/problemset/submission/2005/290170270
代码备份（洛谷）
======

Input
5
8
11 4 16 17 3 24 25 8
8 10 4 21 17 18 25 21
4
6 4 24 13
15 3 1 14
2
13 14
5 8
8
20 17 15 11 21 10 3 7
9 9 4 20 14 9 13 1
2
18 13
15 20
Output
2 36
3 2
2 3
2 36
6 1
 */
