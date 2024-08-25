package p1368;

import java.util.Scanner;

public class CF1368D {
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

    private static String solve() {
        int[] cnt = new int[30];
        for (int x : a) {
            for (int i = 0; i < 30; i++) {
                if ((x >> i & 1) == 1) {
                    cnt[i]++;
                }
            }
        }

        long ans = 0;
        while (n-- > 0) {
            int x = 0;
            for (int i = 0; i < 30; i++) {
                if (cnt[i] > 0) {
                    cnt[i]--;
                    x |= 1 << i;
                }
            }
            ans += (long) x * x;
        }
        return String.valueOf(ans);
    }
}
/*
D. AND, OR and square sum
https://codeforces.com/contest/1368/problem/D

灵茶の试炼 2022-08-12
题目大意：
输入 n(≤2e5) 和一个长为 n 的整数数组 a (0≤a[i]<2^20)。
每次操作，你可以选择两个数 a[i] 和 a[j]，分别记作 x 和 y，然后更新 a[i] = x AND y, a[j] = x OR y。AND 表示按位与，OR 表示按位或。
你可以执行该操作任意次。
输出 sum(a[i]*a[i]) 的最大值，即 a[0]*a[0] + a[1]*a[1] + ... + a[n-1]*a[n-1] 的最大值。
2023.10.8 押题成功！https://leetcode.cn/contest/weekly-contest-366/problems/apply-operations-on-array-to-maximize-sum-of-squares/

rating 1700
https://codeforces.com/contest/1368/submission/167929428
提示 1：操作不会改变 a[i]+a[j] 的值。
提示 2：思考一下题目的样例二，是操作前答案大，还是操作后答案大？你能提出一个更一般的猜想并证明吗？
提示 3：我们应该执行尽量多的操作，把 bit 1 都合并到一起。
具体实现逻辑见代码。
======

input
1
123
output
15129

input
3
1 3 5
output
51

input
2
349525 699050
output
1099509530625
 */
