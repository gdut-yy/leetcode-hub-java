package p209;

import java.util.Scanner;

public class CF209A {
    static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        System.out.println(solve());
    }

    static final int MOD = (int) (1e9 + 7);

    private static String solve() {
        long endWith1 = 0, endWith0 = 0, nothing = 1;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 1) {
                endWith1 = (endWith0 + endWith1 + nothing) % MOD;
            } else {
                endWith0 = (endWith0 + endWith1 + nothing) % MOD;
            }
        }
        long ans = (endWith1 + endWith0) % MOD;
        return String.valueOf(ans);
    }
}
/*
A. Multicolored Marbles
https://codeforces.com/contest/209/problem/A

灵茶の试炼 2022-06-03
题目大意：
求一个长为 n(<=1e6) 的 01 交替串中有多少个 01 交替子序列。对结果模 1e9+7。
注意子序列不要求连续。

rating 1600
n = int(input())
endWith1, endWith0, nothing = 0, 0, 1
for i in range(n):
    if i % 2:
        endWith1 += endWith0 + nothing
    else:
        endWith0 += endWith1 + nothing
print(endWith1 + endWith0)
@小羊肖恩
======

input
3
output
6

input
4
output
11

747
 */