package c310;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Abc310_c {
    static int n;
    static String[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = scanner.next();
        }
        System.out.println(solve());
    }

    private static String solve() {
        Set<String> set = new HashSet<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!set.contains(s[i])) {
                ans++;
                set.add(s[i]);
                set.add(new StringBuilder(s[i]).reverse().toString());
            }
        }
        return String.valueOf(ans);
    }
}
/*
C - Reversible
https://atcoder.jp/contests/abc310/tasks/abc310_c

题目大意：
有 N 根棍子，上面粘着几个球。每个球上都写着一个小写的英文字母。
对于每个 i=1,2,...,N，粘在第 i 根棍子上的球上的字母用字符串 si 表示。具体来说，粘在第 i 根棍子上的球的数量是弦 si 的长度 |si|，而 si 是从棍子一端开始的球上的字母序列。
当从一根棍子的一端开始的球上的字母顺序等于从另一根棍子的一端开始的字母顺序时，两根棍子被认为是相同的。更正式地说，对于 1 到 N 之间的整数 i 和 j，当且仅当 Si 等于 Sj 或其反转时，第 i 和第 j 个球被认为是相同的。
打印 N 个棒中不同棒的数量。

哈希
======

Input 1
6
a
abc
de
cba
de
abc
Output 1
3
 */