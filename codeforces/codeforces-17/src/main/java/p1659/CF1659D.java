package p1659;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1659D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] c = new int[n];
            for (int i = 0; i < n; i++) {
                c[i] = scanner.nextInt();
            }
            System.out.println(solve(n, c));
        }
    }

    private static String solve(int n, int[] c) {
        long s = 0;
        for (int x : c) {
            s += x;
        }
        int k = (int) (s / n);
        // 差分数组
        int[] d = new int[n];
        int sumD = 0;
        int[] a = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            sumD += d[i];
            if (c[i] + sumD == i + 1) {
                a[i] = 1;
            }
            sumD--;
            if (i - k >= 0) {
                d[i - k]++;
            }
            if (a[i] == 1) {
                k--;
            }
        }
        return Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
D. Reverse Sort Sum
https://codeforces.com/contest/1659/problem/D

灵茶の试炼 2023-02-27
题目大意：
输入 t(≤1000) 表示 t 组数据，每组数据输入 n(≤2e5) 和长为 n 的数组 c(0≤c[i]≤n)。
所有数据的 n 之和不超过 2e5。
对于只有 0 和 1 的数组 a，定义 b[i] 为把 a 的前 i 个元素从小到大排序后的新数组（下标从 1 开始）。
定义 c[j] = b[1][j] + b[2][j] + ... + b[n][j]。
现在数组 c 输入给你了，请你构造任意一个符合要求的数组 a。输入保证数组 a 存在。

rating 1900
https://codeforces.com/problemset/submission/1659/195082636
提示 1：从特殊到一般，思考 a 中只有一个 1 时，数组 c 会是什么样的。你可以从这个 1 在末尾开始思考。
看到不变量了吗？
提示 2：a 中 1 的数量等于 sum(c)/n，记作 k。
提示 3：试试倒着构造 a。
提示 4：假设 c[n]=n，此时 a[n]=1。
为了把问题转换成 n-1 个数的问题，需要从 c 中去掉 b[n] 带来的影响。如何去掉？
由于 b[n] 是一个末尾有 k 个 1 的数组，所以把 c 中的 [n-k+1,n] 都减一即可。
用差分数组/树状数组/线段树实现。
继续思考，注意每次都需要把 b[i] 带来的影响去掉。
======

input
5
4
2 4 2 4
7
0 3 4 2 3 2 7
3
0 0 0
4
0 0 0 4
3
1 2 3
output
1 1 0 1
0 1 1 0 0 0 1
0 0 0
0 0 0 1
1 0 1
 */
