package c295;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.Set;

public class Abc295_a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        String[] w = new String[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.next();
        }

        Set<String> set = Set.of("and", "not", "that", "the", "you");
        for (String s : w) {
            if (set.contains(s)) {
                System.out.println("Yes");
                return;
            }
        }
        System.out.println("No");
    }
}
/*
A - Filter
https://atcoder.jp/contests/abc294/tasks/abc294_a

题目大意：
你有 N 个字符串 W1,W2,...,WN，由小写英文字母组成。如果这些字符串中有一个或多个等于 and, not, that, the, or you，则打印 Yes; 否则，打印 No。

HashSet 判断。
======

Input
10
in that case you should print yes and not no
Output
Yes

Input
10
in diesem fall sollten sie no und nicht yes ausgeben
Output
No
 */