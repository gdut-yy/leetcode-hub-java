package p1840;

import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class CF1840E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int T = scanner.nextInt();
        while (T-- > 0) {
            String s1 = scanner.next();
            String s2 = scanner.next();
            int t = scanner.nextInt();
            int q = scanner.nextInt();

            // 预处理
            int n = s1.length();
            char[][] cs = new char[2][n];
            cs[0] = s1.toCharArray();
            cs[1] = s2.toCharArray();
            int time = 0;
            // 不同的个数
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (cs[0][i] != cs[1][i]) cnt++;
            }

            Queue<int[]> queue = new ArrayDeque<>();
            while (q-- > 0) {
                int op = scanner.nextInt();

                // 看阻塞的状态能否解除
                while (!queue.isEmpty() && queue.peek()[1] <= time) {
                    int pos = queue.remove()[0];
                    if (cs[0][pos] != cs[1][pos]) cnt++;
                }
                if (op == 1) {
                    int pos = scanner.nextInt() - 1;
                    // 阻塞了的就不用算不同了
                    if (cs[0][pos] != cs[1][pos]) cnt--;
                    queue.add(new int[]{pos, time + t});
                } else if (op == 2) {
                    int idx1 = scanner.nextInt() - 1, pos1 = scanner.nextInt() - 1;
                    int idx2 = scanner.nextInt() - 1, pos2 = scanner.nextInt() - 1;
                    // 先减
                    if (cs[0][pos1] != cs[1][pos1]) cnt--;
                    if (cs[0][pos2] != cs[1][pos2]) cnt--;
                    // swap
                    char tmp = cs[idx1][pos1];
                    cs[idx1][pos1] = cs[idx2][pos2];
                    cs[idx2][pos2] = tmp;
                    // 后加
                    if (cs[0][pos1] != cs[1][pos1]) cnt++;
                    if (cs[0][pos2] != cs[1][pos2]) cnt++;
                } else {
                    System.out.println(cnt == 0 ? "YES" : "NO");
                }
                time++;
            }
        }
    }
}
/*
E. Character Blocking
https://codeforces.com/contest/1840/problem/E

题目大意：
给定两个长度相等的字符串 s1 和 s2，由小写拉丁字母和一个整数 t 组成。
您需要回答 q 个查询，编号从 1 到 q。第 i 个查询在第 i 秒出现。每个查询都是以下三种类型之一:
- 将两个字符串中位于位置 pos(从 1 开始索引)的字符阻塞 t 秒;
- 交换两个未阻塞字符;
- 确定两个字符串在查询时是否相等，忽略阻塞字符。
注意，在第二种类型的查询中，被交换的字符可以来自同一个字符串，也可以来自 s1 和 s2。
---
输入的第一行包含单个整数 T(1≤T≤10^4)—测试用例的数量。
然后遵循测试用例的描述。
每个测试用例的第一行包含一个由小写拉丁字母组成的字符串 s1。
每个测试用例的第二行包含一个由小写拉丁字母组成的字符串 s2。
字符串的长度相等。
每个测试用例的第三行包含两个整数 t 和 q(1≤t,q≤2·10^5)。数字 t 表示字符被阻塞的秒数。数字 q 对应于查询的次数。
每个测试用例的下 q 行都包含一个查询。每个查询都是以下三种类型之一:
- "1 pos " 将两个字符串中位于位置 pos 的字符阻塞 t 秒;
- "2 1/2 pos1 1/2 pos2 " 交换两个未阻塞的字符。
  - 查询中的第二个数字表示从其中获取交换的第一个字符的字符串的编号。
  - 查询中的第三个数字表示该字符在该字符串中的位置。
  - 查询中的第四个数字表示从其中获取交换的第二个字符的字符串的编号。
  - 查询中的第五个数字表示该字符在该字符串中的位置;
- "3 " 确定两个字符串在查询时是否相等，忽略阻塞字符。
对于第一种类型的查询，可以保证在查询时，位置 pos 上的字符不会被阻塞。
对于第二种类型的查询，可以保证被交换的字符不会被阻塞。
pos、pos1、pos2 的所有值都在 1 到字符串长度的范围内。
所有测试用例的 q 值之和，以及字符串的总长度 s1，都不超过 2⋅10^5。

模拟。队列 模拟 阻塞队列
======

input
2
codeforces
codeblocks
5 7
3
1 5
1 6
1 7
1 9
3
3
cool
club
2 5
2 1 2 2 3
2 2 2 2 4
1 2
3
3
output
NO
YES
NO
YES
NO
 */
