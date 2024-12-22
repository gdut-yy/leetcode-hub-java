package p761;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF761D {
    static int n, l, r;
    static int[] a, pos;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        l = scanner.nextInt();
        r = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        pos = new int[n];
        for (int i = 0; i < n; i++) {
            int v = scanner.nextInt() - 1;
            pos[v] = i;
        }
        System.out.println(solve());
    }

    private static String solve() {
        int pre = Integer.MIN_VALUE;
        for (int p : pos) {
            pre = Math.max(pre + 1, l - a[p]);
            a[p] += pre;
            if (a[p] > r) {
                return "-1";
            }
        }
        return Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
D. Dasha and Very Difficult Problem
https://codeforces.com/contest/761/problem/D

灵茶の试炼 2024-09-25
题目大意：
输入 n(1≤n≤1e5) l r(1≤l≤r≤1e9) 和长为 n 的数组 a(l≤a[i]≤r)，以及一个 1~n 的排列 p。
有两个长为 n 的数组 a 和 b，元素范围均在 [l,r] 中。
数组 a 已经输入给你了，但你不知道 b。
定义 c[i]=b[i]-a[i]。
已知数组 c 中的元素互不相同，且 c 离散化后的结果是排列 p。
构造一个符合要求的数组 b。
如果无法构造，输出 -1。

rating 1700
c[i] 的范围是 [l-a[i],r-a[i]]。
按照 p 从小到大的顺序，贪心地想：
最小的 c[i] 取最小的 l-a[i] 是最优的，这样后面的数可选的范围更大。将 l-a[i] 记作 pre。
次小的 c[i] 要比前面大一点点，但又不能低于 l-a[i]，故取 max(pre+1, l-a[i])，再将其记作 pre。
依此类推，可以计算出 c 数组。
最后根据 b[i] = a[i] + c[i] 计算出 b[i]。
如果存在 b[i] > r 则输出 -1。
代码 https://codeforces.com/problemset/submission/761/282636561
======

Input
5 1 5
1 1 1 1 1
3 1 5 4 2
Output
3 1 5 4 2

Input
4 2 9
3 4 8 9
3 2 1 4
Output
2 2 2 9

Input
6 1 5
1 1 1 1 1 1
2 3 5 4 1 6
Output
-1
 */