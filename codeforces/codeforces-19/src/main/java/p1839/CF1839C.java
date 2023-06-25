package p1839;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CF1839C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve(n, a));
        }
    }

    private static String solve(int n, int[] a) {
        if (a[n - 1] == 1) {
            return "NO";
        }

        int i = 0;
        List<String> resList = new ArrayList<>();
        while (i < n) {
            int cnt0 = 0, cnt1 = 0;
            while (i < n && a[i] == 1) {
                cnt1++;
                i++;
            }
            while (i < n && a[i] == 0) {
                cnt0++;
                i++;
            }
            String ans = "0 ".repeat(cnt0 + cnt1 - 1) + cnt1;
            resList.add(ans);
        }

        // 后往前，要翻转
        Collections.reverse(resList);
        return "YES" + System.lineSeparator()
                + String.join(" ", resList);
    }
}
/*
C. Insert Zero and Invert Prefix
https://codeforces.com/contest/1839/problem/C

题目大意：
你有一个长度为 n 的序列 a1,a2,...,an，它的每个元素要么是 0 要么是 1，还有一个序列 b，它最初是空的。
你将执行 n 个操作。每一个 b 的长度都会增加 1。
在第 i 次操作中，选择一个介于 0 和 i-1 之间的整数 p。你在序列 b 的位置 p+1 上插入 0(在前 p 个元素之后)，然后对 b 的前 p 个元素进行反转。
更正式地说:我们将第 i-th(1≤i≤n)运算之前的序列 b 表示为 b1,b2,...,bi-1。在第 i 次操作中，选择一个 0 到 i-1 之间的整数 p，并将 b 替换为 {b1},{b2},...,{bp},0,b[p+1],b[p+2],...,b[i-1]。这里，{x} 表示二进制反转。因此，{0}=1 和 {1}=0。
您可以在 Notes 部分中找到操作示例。
确定是否存在使 b 等于 a 的操作序列。如果存在这样的操作序列，找到它。

constructive algorithms
按 1 开头 0 结尾的 模式进行分组
如 00110011001100 分组为 00 1100 1100 1100
构造 1100 相当于 先插入 000，再在下标 2 插入 0
======

input
4
5
1 1 0 0 0
1
1
3
0 1 1
6
1 0 0 1 1 0
output
YES
0 0 2 1 3
NO
NO
YES
0 1 0 2 4 2
 */
