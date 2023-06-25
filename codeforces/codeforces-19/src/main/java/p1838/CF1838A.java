package p1838;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF1838A {
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
        Arrays.sort(a);
        return a[0] < 0 ? String.valueOf(a[0]) : String.valueOf(a[n - 1]);
    }
}
/*
Codeforces Round 877 (Div. 2) https://www.bilibili.com/video/BV1iV4y1U7Ua/
A. Blackboard List
https://codeforces.com/contest/1838/problem/A

题目大意：
黑板上写着两个整数。之后，进行 n−2 次以下步骤:
- 在黑板上选择任意两个整数，在黑板上写出它们之差的绝对值。
这个过程完成后，n 个整数的列表被洗牌。你会得到最后的名单。恢复最初两个数字中的一个。您不需要恢复另一个。
您可以保证可以使用上述流程生成输入。

分类讨论，如果最小的是负数，输出最小的，因为过程中不会产生负数。
否则输出最大的数
======

input
9
3
9 2 7
3
15 -4 11
4
-9 1 11 -10
5
3 0 0 0 3
7
8 16 8 0 8 16 8
4
0 0 0 0
10
27 1 24 28 2 -1 26 25 28 27
6
600000000 800000000 0 -200000000 1000000000 800000000
3
0 -1000000000 1000000000
output
9
11
-9
3
8
0
-1
600000000
0
 */
