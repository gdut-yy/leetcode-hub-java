package nc65051;

import java.util.Arrays;
import java.util.Scanner;

public class NC65051C {
    static int n, k;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static final int MOD = (int) (1e9 + 7);

    private static String solve() {
        Arrays.sort(a);

        // 后 k+1 个数乘积
        long prod = 1;
        for (int i = 0; i < k + 1; i++) {
            prod = prod * a[n - 1 - i] % MOD;
        }
        long ans = 0;
        // n-(k+1) 个数不变
        for (int i = 0; i < n - (k + 1); i++) {
            ans += a[i];
        }
        ans += k + prod;
        ans %= MOD;
        return String.valueOf(ans);
    }
}
/*
小美的游戏
https://ac.nowcoder.com/acm/contest/65051/C

题目描述
小美有一个长度为 n 的数组，她最多可以进行 k 次操作，每次操作如下：
1. 选择两个整数 i,j(1≤i<j≤n)
2. 选择两个整数 x,y，使得 x×y=ai×aj
3. 将 ai 替换为 x，将 aj 替换为 y
她希望最多进行 k 次操作之后，最后数组中的元素的总和尽可能大。
输入描述:
一行两个整数 n,k，表示数组的长度和操作的次数。
一行 n 个整数 a1,a2,⋯,an，表示数组的元素。
1≤k<n≤10^5
1≤ai≤10^5
输出描述:
输出一个整数，表示最后数组中的元素的总和的最大值，由于答案可能很大，你只需要输出答案对 10^9 +7 取模的结果。

贪心，大的相乘，其余的相加
======

示例1
输入
5 2
1 2 3 4 5
输出
65
说明
第一次操作后，数组变为 [1, 2, 12, 1, 5]
第二次操作，数组变为 [1, 2, 60, 1, 1]
 */