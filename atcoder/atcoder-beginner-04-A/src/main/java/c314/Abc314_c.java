package c314;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Abc314_c {
    static int n, m;
    static char[] cs;
    static int[] c;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        m = scanner.nextInt();
        cs = scanner.next().toCharArray();
        c = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        Map<Integer, List<Integer>> posMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            posMap.computeIfAbsent(c[i], key -> new ArrayList<>()).add(i);
        }
        for (List<Integer> ids : posMap.values()) {
            char last = cs[ids.get(ids.size() - 1)];
            for (int i = ids.size() - 1; i >= 1; i--) {
                int x = ids.get(i - 1);
                int y = ids.get(i);
                cs[y] = cs[x];
            }
            cs[ids.get(0)] = last;
        }
        return new String(cs);
    }
}
/*
C - Rotate Colored Subsequence
https://atcoder.jp/contests/abc314/tasks/abc314_c

题目大意：
给定一个长度为 N 的字符串 S，由小写英文字母组成。S 的每个字符都用 M 颜色中的一种绘制:颜色 1、颜色 2、……，颜色 M;对于每个 i=1,2,...,N, S 的第 i 个字符被涂成 ci 颜色。
对于这个顺序中的每一个 i=1,2,...,M，让我们执行以下操作。
- 执行正确的循环移位 1 S 画颜色我。也就是说,如果 p1th, p2th, p3th,...,pkth 字符画的颜色从左到右,然后同时取代 p1th, p2th, p3th,...,pkth 的 S 和 pkth, p1th, p2th,...,pk−1 个字符(S)。
打印上述操作后的最后一个 S。
这些约束保证 S 中至少有一个字符用 M 种颜色中的每一种涂上。
---
最初，S= apzbqrcs。
对于 i=1，对由第 1 个、第 4 个、第 7 个字符组成的 S 部分右圆移动 1，得到 S= cpzaqrbs。
对于 i=2，对由第 2、第 5、第 6、第 8 个字符组成的 S 部分右圆移动 1，得到 S= cszapqbr。
对于 i=3，对由第 3 个字符组成的 S 部分右圆移动 1，得到 S= cszapqbr(这里 S 没有改变)。
因此，您应该打印最后的 S。

======

Input 1
8 3
apzbqrcs
1 2 3 1 2 2 1 2
Output 1
cszapqbr

Input 2
2 1
aa
1 1
Output 2
aa
 */