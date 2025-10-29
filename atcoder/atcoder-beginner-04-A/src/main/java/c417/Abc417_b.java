package c417;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Abc417_b {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) b[i] = scanner.nextInt();

        Map<Integer, Integer> cntB = new HashMap<>();
        for (int v : b) {
            cntB.merge(v, 1, Integer::sum);
        }
        List<Integer> arr = new ArrayList<>();
        for (Integer v : a) {
            if (cntB.merge(v, -1, Integer::sum) < 0) {
                arr.add(v);
            }
        }
        String res = arr.stream().map(String::valueOf).collect(Collectors.joining(" "));
        out.println(res);
    }
}
/*
B - Search and Delete
https://atcoder.jp/contests/abc417/tasks/abc417_b

题目大意：
高桥有一个长度为 N 的整数序列 A=(A_1,A_2,...,A_N) 。
可以保证 A 不递减。
高桥对这个整数序列进行了 M 次运算。在 i-th 运算 (1 <= i <= M) 中，他进行了如下运算：
> 如果序列 A 包含 B_i 元素，则选择一个这样的元素并删除它。如果不存在这样的元素，则什么也不做。
> 需要注意的是，由于 A 是非递减的，因此无论选择哪个元素，操作后的序列都是唯一确定的，并且仍然是非递减的。
在执行 M 操作后找到 A 。

a 减去 a 和 b 的交集。
======

Input 1
8 5
1 2 2 3 3 3 5 6
2 2 7 3 2
Output 1
1 3 3 5 6

Input 2
1 2
1
1 1
Output 2

 */
