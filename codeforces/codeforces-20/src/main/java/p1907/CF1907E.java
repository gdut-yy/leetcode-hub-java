package p1907;

import java.util.Scanner;

public class CF1907E {
    static int n;

    public static void main(String[] args) {
//        table();
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            System.out.println(solve());
        }
    }

    static void table() {
        for (int target = 0; target < 10; target++) {
            int cnt = 0;
            for (int i = 0; i <= target; i++) {
                for (int j = 0; j <= target; j++) {
                    for (int k = 0; k <= target; k++) {
                        if (i + j + k == target
                                && digsum(i) + digsum(j) + digsum(k) == digsum(target)) {
                            cnt++;
                        }
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    static int digsum(int n) {
        int res = 0;
        while (n > 0) {
            res += n % 10;
            n /= 10;
        }
        return res;
    }

    static int[] a = {1, 3, 6, 10, 15, 21, 28, 36, 45, 55};

    private static String solve() {
        long ans = 1;
        while (n > 0) {
            int x = n % 10;
            ans *= a[x];
            n /= 10;
        }
        return String.valueOf(ans);
    }
}
/*
E. Good Triples
https://codeforces.com/contest/1907/problem/E

题目大意：
给定一个非负整数 n (n≥0)。假设如果 a+b+c=n，且 digsum(a)+digsum(b)+digsum(c)=digsum(n)，则非负整数(a,b,c)的三元组是好的，其中 digsum(x)是数字 x 的数字之和。
例如，如果 n=26，那么配对(4,12,10)是好的，因为 4+12+10=26，并且(4)+(1+2)+(1+0)=(2+6)。
你的任务是找出给定数字 n 的良好三元组的个数。三位数的顺序很重要。例如，三元组(4,12,10)和(10,12,4)是两个不同的三元组。

打表
======

input
12
11
0
1
2
3
4
5
3141
999
2718
9999999
10000000
output
9
1
3
6
10
15
21
1350
166375
29160
1522435234375
3
 */
