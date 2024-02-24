package p439;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF439C {
    static int n, k, even;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        even = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        List<Integer>[] g = new ArrayList[2];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int v : a) {
            g[v & 1].add(v);
        }
        List<Integer> e = g[0];
        List<Integer> o = g[1];

        int odd = k - even;
        int leftOdd = o.size() - odd;
        if (leftOdd < 0 || (leftOdd & 1) > 0 || e.size() + leftOdd / 2 < even) {
            return "NO";
        }

        List<String> ans = new ArrayList<>();
        ans.add("YES");
        if (even == 0) {
            odd--;
        }
        for (int i = 0; i < odd; i++) {
            ans.add("1 " + o.get(i));
        }
        o = o.subList(odd, o.size());
        for (int i = 1; i < even; i++) {
            if (!e.isEmpty()) {
                ans.add("1 " + e.get(0));
                e = e.subList(1, e.size());
            } else {
                ans.add("2 " + o.get(0) + " " + o.get(1));
                o = o.subList(2, o.size());
            }
        }

        e.addAll(o);
        ans.add(e.size() + " " + e.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        return String.join(System.lineSeparator(), ans);
    }
}
/*
C. Devu and Partitioning of the Array
https://codeforces.com/contest/439/problem/C

灵茶の试炼 2022-06-28
题目大意：
【易错题】
输入整数 n, k(1<=k<=n<=1e5) 和 p(0<=p<=k)，以及 n 个不同的整数表示数组 a（1<=a[i]<=1e9)。
请你将 a 分割为 k 个子序列（子序列不要求连续），使得恰好有 p 个子序列的和均为偶数，k-p 个子序列的和均为奇数。
若不能分割，输出 "NO"；否则输出 "YES" 和 k 行，每行第一个数表示子序列的大小，然后是子序列的数。
输出任意一种合法方案，输出的顺序与输入的顺序无关。

rating 1700
constructive algorithms
https://codeforces.com/problemset/submission/439/162015618
把所有数字按照奇偶性分成两组，叫做 e 组和 o 组（表示 even 和 odd）。
构造方案：
e 组每个元素当作一个和为偶数的子序列。
o 组每个元素当作一个和为奇数的子序列。
o 组剩余元素，两两一组，当作一个和为偶数的子序列。
如此构造出 k-1 个子序列，剩余数字再组成一个子序列。
输出 NO 的情况：
1. o 组大小不足 k-p
2. o 组大小的奇偶性和 k-p 的奇偶性不同
3. 无法构造出足够多的和为偶数的子序列
推荐看看我上面贴的实现。有一些简化代码的小技巧。
======

input
5 5 3
2 6 10 5 9
output
YES
1 9
1 5
1 10
1 6
1 2

input
5 5 3
7 14 2 9 5
output
NO

input
5 3 1
1 2 3 7 5
output
YES
3 5 1 3
1 7
1 2
 */
