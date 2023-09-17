package c314;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Abc314_d {
    static int n;
    static char[] s;
    static int q;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        s = scanner.next().toCharArray();
        q = scanner.nextInt();

        // 不受影响的
        set = new HashSet<>();
        // 1:大写 -1:小写
        flag = 0;
        for (int i = 0; i < q; i++) {
            int t = scanner.nextInt();
            int x = scanner.nextInt() - 1;
            char c = scanner.next().charAt(0);
            if (t == 1) {
                s[x] = c;
                set.add(x);
            } else if (t == 2) {
                flag = -1;
                set.clear();
            } else if (t == 3) {
                flag = 1;
                set.clear();
            }
        }
        System.out.println(solve());
    }

    static Set<Integer> set;
    static int flag;

    private static String solve() {
        for (int i = 0; i < n; i++) {
            if (flag == 0) {
                // do nothing
            } else if (flag == -1) {
                if (!set.contains(i)) {
                    s[i] = Character.toLowerCase(s[i]);
                }
            } else if (flag == 1) {
                if (!set.contains(i)) {
                    s[i] = Character.toUpperCase(s[i]);
                }
            }
        }
        return new String(s);
    }
}
/*
D - LOWER
https://atcoder.jp/contests/abc314/tasks/abc314_d

题目大意：
给定一个长度为 N 的字符串 S，由大写和小写英文字母组成。
让我们对字符串 s 执行 Q 个操作。第 i 个操作(1≤i≤Q)由两个整数和一个字符组成的元组(t1, xi, ci)表示，如下所示。
如果 ti =1，将 S 的 xi-th 字符改为 ci。
如果 ti =2，将 S 中的所有大写字母转换为小写字母(不使用 xi,ci 进行此操作)。
如果 ti =3，将 S 中的所有小写字母转换为大写字母(此操作不使用 xi,ci)。
在 Q 操作之后打印 S。

======

Input 1
7
AtCoder
5
1 4 i
3 0 a
1 5 b
2 0 a
1 4 Y
Output 1
atcYber

Input 2
35
TheQuickBrownFoxJumpsOverTheLazyDog
10
2 0 a
1 19 G
1 13 m
1 2 E
1 21 F
2 0 a
1 27 b
3 0 a
3 0 a
1 15 i
Output 2
TEEQUICKBROWMFiXJUGPFOVERTBELAZYDOG
 */