package p710;

import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class CF710E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        System.out.println(solve(n, x, y));
    }

    // https://codeforces.com/blog/entry/46761
    private static String solve(int n, int x, int y) {
        long[] z = new long[n + 2];
        Arrays.fill(z, Long.MAX_VALUE);

        Deque<long[]> dq = new ArrayDeque<>();
        z[0] = 0;
        for (int i = 0; i < n + 1; i++) {
            while (!dq.isEmpty() && dq.getFirst()[1] < i) dq.removeFirst();

            if (!dq.isEmpty()) z[i] = Math.min(z[i], dq.getFirst()[0] - (long) i * x);

            long[] cur = {z[i] + y + 2L * i * x, 2L * i};
            while (!dq.isEmpty() && dq.getLast()[0] > cur[0]) dq.removeLast();
            dq.addLast(cur);

            z[i + 1] = Math.min(z[i + 1], z[i] + x);
        }
        return String.valueOf(z[n]);
    }
}
/*
E. Generate a String
https://codeforces.com/contest/710/problem/E

灵茶の试炼 2023-05-08
题目大意：
Zscoder 想为一些编程竞赛问题生成一个输入文件。
他的输入是一个由 n 个字母“a”组成的字符串。他懒得编写生成器，所以他将在文本编辑器中手动生成输入。
最初，文本编辑器是空的。从文本文件中插入或删除字母“a”需要 x 秒，复制整个文本文件的内容需要 y 秒，并复制它。
Zscoder 想要找到创建恰好包含 n 个字母“a”的输入文件所需的最少时间。帮助他确定生成输入所需的时间。

rating 2000
相似题目: B. Two Buttons
https://codeforces.com/contest/520/problem/B
======

input
8 1 1
output
4

input
8 1 10
output
8

35896 278270961 253614967
 */
