package p788;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF788A {
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
        List<Integer> d = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            d.add(Math.abs(a[i] - a[i - 1]));
        }
        ans = 0;
        f(d);
        f(d.subList(1, d.size()));
        return String.valueOf(ans);
    }

    static long ans;

    static void f(List<Integer> a) {
        long s = 0;
        for (int i = 0; i < a.size(); i++) {
            long v = a.get(i);
            if ((i & 1) > 0) {
                v = -v;
            }
            s = Math.max(s + v, v);
            ans = Math.max(ans, s);
        }
    }
}
/*
A. Functions again
https://codeforces.com/contest/788/problem/A

灵茶の试炼 2022-07-07
题目大意：
输入 n(<=1e5) 和长为 n 的整数数组 a(-1e9<=a[i]<=1e9)。
在满足 1<=l<r<=n 的前提下，输出 f(l,r) 的最大值（下列式子中的数组下标从 1 开始）。
f(l,r)={\sum_{i=l}^{r-1} } =\left | a[i]-a[i+1] \right | \times (-1)^{i-l}

rating 1600
https://codeforces.com/contest/788/submission/118121760
提示 1：奇偶性相同的 l，(-1)^(i-l) 的变化规律是一样的。
提示 2：求的是 abs(a[i]-a[i+1])*(-1)^(i-l) 的最大子段和。
提示 3：对 a 和 a[1:] 分别求一下，取最大值。
======

input
5
1 4 2 3 1
output
3

input
4
1 5 4 7
output
6
 */
