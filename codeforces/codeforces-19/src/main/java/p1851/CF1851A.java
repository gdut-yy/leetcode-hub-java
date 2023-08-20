package p1851;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1851A {
    static int n, m, k, h;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            k = scanner.nextInt();
            h = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        int ans = 0;
        int min = h - (m - 1) * k;
        int max = h + (m - 1) * k;
        for (int x : a) {
            if (min <= x && x <= max && x != h) {
                if (Math.abs(x - h) % k == 0) {
                    ans++;
                }
            }
        }
        return String.valueOf(ans);
    }
}
/*
Codeforces Round 888 (Div. 3)
A. Escalator Conversations
https://codeforces.com/contest/1851/problem/A

题目大意：
有一天，弗拉德很好奇，在地铁的自动扶梯上他能和谁说话。一共有 n 名乘客。自动扶梯共有 m 级台阶，所有台阶的索引为 1 到 m，第 i 级台阶的高度为 i⋅k。
弗拉德的身高是 H 厘米。身高 a 和 b 的两个人站在不同的台阶上，如果他们之间的高度差等于台阶之间的高度差，他们可以在自动扶梯上交谈。
例如，两个人身高分别为 170 厘米和 180 厘米，m=10,k=5，那么他们可以站在 7 号和 5 号台阶上，台阶之间的高度差等于两个人之间的高度差:k·2=5·2=10=180−170。还有其他可能的方法。
给定一个大小为 n 的数组 h，其中 hi 表示第 i 个人的高度。弗拉德感兴趣的是在自动扶梯上他能和多少人单独交谈。
例如，如果 n=5,m=3,k=3,H=11,H=[5,4,14,18,2]，则 Vlad 可以与身高为 5 的人(Vlad 站在第 1 步，另一个人站在第 3 步)和身高为 14 的人(Vlad 站在第 2 步，另一个人站在第 3 步)进行对话。弗拉德无法与身高 2 的人交谈，因为即使他们站在自动扶梯的极端台阶上，他们之间的高度差也是 6，而他们的高度差是 9。弗拉德不能和电梯上的其他人交谈，所以这个例子的答案是 2。

枚举。
注意要求站在不同的台阶上。
因此高度不能相等。
======

input
7
5 3 3 11
5 4 14 18 2
2 9 5 6
11 9
10 50 3 11
43 44 74 98 62 60 99 4 11 73
4 8 8 49
68 58 82 73
7 1 4 66
18 66 39 83 48 99 79
9 1 1 13
26 23 84 6 60 87 40 41 25
6 13 3 28
30 70 85 13 1 55
output
2
1
4
1
0
0
3
 */
