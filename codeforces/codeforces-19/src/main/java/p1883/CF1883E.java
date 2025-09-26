package p1883;

import java.util.Scanner;

public class CF1883E {
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

    private static String solve() {
        long ans = 0;
        long p2 = 0;
        for (int i = 1; i < n; i++) {
            int pre = a[i - 1];
            if (a[i] <= pre) {
                p2 += bitsLen((pre - 1) / a[i]);
            } else {
                p2 = Math.max(p2 - bitsLen((a[i] / pre)) + 1, 0);
            }
            ans += p2;
        }
        return String.valueOf(ans);
    }

    // bits.Len:
    // Len returns the minimum number of bits required to represent x; the result is 0 for x == 0.
    static int bitsLen(long x) {
        return 64 - Long.numberOfLeadingZeros(x);
    }
}
/*
E. Look Back
https://codeforces.com/contest/1883/problem/E

灵茶の试炼 2024-04-24
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤1e5) 和长为 n 的数组 a(1≤a[i]≤1e9)。
每次操作，你可以把一个 a[i] 变成 a[i] * 2。
你需要使数组 a 非递减，也就是 a[i] <= a[i+1]。
输出最少操作次数。
附赠一个爆 LL 的数据：
1
200
3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2 3 2

rating 1700
由于操作是把数字变大，第一个数肯定不用操作。
如果 a[i] <= a[i-1]，那么 a[i] 至少要操作 (a[i-1]-1)/a[i] 的二进制长度次（0 的长度是 0）才能 >= a[i-1]。（也可以写 for 循环计算。）
在此基础上，如果 a[i-1] 操作了 p2 次，那么 a[i] 就需要额外操作 p2 次。
如果 a[i] > a[i-1]，先计算把 a[i] 除 2 使得 a[i] 刚好 >= a[i-1] 的除 2 次数，这需要 a[i]/a[i-1] 的二进制长度次，设其为 k。
在此基础上，如果 a[i-1] 操作了 p2 次，那么 a[i] 就需要操作 max(p2 - k, 0) 次。
https://codeforces.com/problemset/submission/1883/257866706
======

Input
9
1
1
2
2 1
3
3 2 1
4
7 1 5 3
5
11 2 15 7 10
6
1 8 2 16 8 16
2
624323799 708290323
12
2 1 1 3 3 11 12 22 45 777 777 1500
12
12 11 10 9 8 7 6 5 4 3 2 1
Output
0
1
3
6
10
3
0
2
66
 */