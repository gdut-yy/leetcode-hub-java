package p1513;

import java.util.Scanner;

public class CF1513B {
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

    private static final int MOD = (int) (1e9 + 7);

    private static String solve() {
        int and = -1;
        for (int v : a) {
            and &= v;
        }
        long cnt = 0;
        for (int v : a) {
            if (v == and) {
                cnt++;
            }
        }
        long ans = cnt * (cnt - 1);
        for (int i = 2; i <= n - 2; i++) {
            ans = ans * i % MOD;
        }
        return String.valueOf(ans);
    }
}
/*
B. AND Sequences
https://codeforces.com/contest/1513/problem/B

灵茶の试炼 2024-03-05
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(2≤n≤2e5) 和长为 n 的数组 a(0≤a[i]≤1e9)。
把数组 a 重新排列为数组 b，使得对于所有 1≤i≤n-1，满足：
b 的长为 i 的前缀的 AND，等于 b 的长为 n-i 的后缀的 AND（按位与）。
输出有多少个【元素下标不同】的 b，模 1e9+7。
例如 a=[1,1,1] 有 6 个【元素下标不同】的排列，虽然这些排列都是 [1,1,1]。

rating 1400
单独考察一个比特位。
如果所有 a[i] 在这一位上都是 1，我们怎么排都可以。
如果有 0，那么必须在最左和最右放 0。
把这个结论推广到所有比特位，设 a 的所有元素的 AND 为 x，我们必须在最左和最右放 x。
设 x 在 a 中出现了 cnt 次，那么有 A(cnt,2) = cnt*(cnt-1) 种放置两个 x 的方案。
剩下的 n-2 个数随意排，有 (n-2)! 种方案。
所以答案为 cnt*(cnt-1)*(n-2)!。
记得取模，以及使用 64 位 int。
https://codeforces.com/problemset/submission/1513/249565041
======

Input
4
3
1 1 1
5
1 2 3 4 5
5
0 2 0 3 0
4
1 3 5 1
Output
6
0
36
4
 */
