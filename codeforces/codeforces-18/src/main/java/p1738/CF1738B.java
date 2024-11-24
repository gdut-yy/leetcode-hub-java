package p1738;

import java.util.Scanner;

public class CF1738B {
    static int n, k;
    static long[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            k = scanner.nextInt();
            s = new long[k];
            for (int i = 0; i < k; i++) {
                s[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        if (k > 1 && s[0] > (n - k + 1) * (s[1] - s[0])) {
            return "No";
        }
        for (int i = 2; i < k; i++) {
            if (s[i - 1] * 2 > s[i] + s[i - 2]) {
                return "No";
            }
        }
        return "Yes";
    }
}
/*
B. Prefix Sum Addicts
https://codeforces.com/contest/1738/problem/B

灵茶の试炼 2024-02-12
题目大意：
输入 T(≤1e5) 表示 T 组数据。所有数据的 n 之和 ≤1e5。
每组数据输入 n k (1≤k≤n≤1e5) 和 k 个整数，范围 [-1e9,1e9]。
这 k 个数是一个长为 n 的非降数组的前缀和的最后 k 项（从左到右）。
是否存在这样的非降数组？输出 Yes 或 No。

rating 1200
由于前缀和的差分就是原数组，我们可以检查相邻前缀和的差是否非降，即如果存在 s[i-1]-s[i-2] > s[i]-s[i-1]，输出 No。
这样就够了吗？
设输入的前缀和为 s[n-k+1],s[n-k+2],...,s[n]。
如果 k>1，计算 s[n-k+2]-s[n-k+1] 可以得到 a[n-k+2]。
那么有 s[n-k+1] = a[1]+a[2]+...+a[n-k+1] <= (n-k+1) * a[n-k+2] = (n-k+1) * (s[n-k+2]-s[n-k+1])
也就是把每个 a[i] 都放大到 a[n-k+2]。
如果不满足上式，输出 No。
否则输出 Yes。
https://codeforces.com/problemset/submission/1738/244271075
======

input
4
5 5
1 2 3 4 5
7 4
-6 -5 -3 0
3 3
2 3 4
3 2
3 4
output
Yes
Yes
No
No
 */
