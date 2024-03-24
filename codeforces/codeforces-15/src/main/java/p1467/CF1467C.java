package p1467;

import java.util.Arrays;
import java.util.Scanner;

public class CF1467C {
    static int[] n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = new int[3];
        for (int i = 0; i < 3; i++) {
            n[i] = scanner.nextInt();
        }
        sum = new long[3];
        min = new long[3];
        for (int i = 0; i < 3; i++) {
            long s = 0;
            int mn = (int) 1e9;
            for (int j = 0; j < n[i]; j++) {
                int v = scanner.nextInt();
                s += v;
                mn = Math.min(mn, v);
            }
            sum[i] = s;
            min[i] = mn;
        }
        System.out.println(solve());
    }

    static long[] sum, min;

    private static String solve() {
        Arrays.sort(sum);
        Arrays.sort(min);
        long ans = sum[1] + sum[2] - sum[0];
        long s2 = sum[0] + sum[1] + sum[2] - (min[0] + min[1]) * 2;
        ans = Math.max(ans, s2);
        return String.valueOf(ans);
    }
}
/*
C. Three Bags
https://codeforces.com/contest/1467/problem/C

灵茶の试炼 2022-07-26
题目大意：
输入三个不超过 3e5 的正整数 n1 n2 n3，且 n1+n2+n3≤3e5。
然后输入三个长度分别为 n1 n2 n3 的整数数组，数组元素均在 [1,1e9] 内。
每次操作你可以选择两个非空数组 a 和 b，把 a 中的一个数字 x 移除掉，然后把 b 中的一个数字 y 修改为 y-x。
这样操作 n1+n2+n3-1 次后，就只剩下一个数字了，输出这个数字的最大值。

rating 1900
https://codeforces.com/contest/1467/submission/165643711
提示：负负得正。
提示：试试 n=1 和 n=2 这种数据很小的情况，从小数据入手去研究规律。
任意最优操作方案都可以分为如下两类：
第一类：
1. b 全部减到 a；
2. c 留一个数字，其余全部减到 a；
3. a 减到 c 剩下的那个数字上。
这样结果是 sum(b)+sum(c)-sum(a)，我们选择 sum() 最小的那个数组当作 a。
第二类：
1. b c 各留一个最小的数字，其余全部减到 a；
2. a 留一个最小的数字，其余全部减到 b 剩下的那个数字上；
3. a b 减到 c 剩下的那个数字上。
这样结果是 sum(a)+sum(b)+sum(c)-2*min(a)-2*min(b)，我们选择 min() 最小和次小的数组作为 a 和 b。
这两类方案的最大值为答案。
如果你没有想到上面的，或者想漏了一种，这里还有一种无脑爆搜的做法：
把每个数组分为最小值和其余值的和，这样至多有 6 个元素，然后搜索模拟所有可能的操作，取最大值。代码如下：
https://codeforces.com/contest/1467/submission/165648547
======

input
2 4 1
1 2
6 3 4 5
5
output
20

input
3 2 2
7 5 4
2 9
7 1
output
29
 */