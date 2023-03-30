package p1807;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class CF1807C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            String s = scanner.next();
            System.out.println(solve(n, s));
        }
    }

    private static String solve(int n, String s) {
        List<Set<Character>> oddEvenSets = new ArrayList<>();
        oddEvenSets.add(new HashSet<>());
        oddEvenSets.add(new HashSet<>());

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            oddEvenSets.get(i & 1).add(ch);
        }

        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (oddEvenSets.get(0).contains(ch) && oddEvenSets.get(1).contains(ch)) {
                return "NO";
            }
        }
        return "YES";
    }
}
/*
C. Find and Replace
https://codeforces.com/contest/1807/problem/C

题目大意：
您将得到一个由小写拉丁字符组成的字符串 s。在操作中，您可以取一个字符并将该字符的所有出现替换为 0 或将该字符的所有出现替换为 1。
是否有可能执行一些移动，从而产生的字符串是一个交替的二进制字符串†?
例如，考虑字符串 abacaba。您可以执行以下操作:
用 0 代替 a。现在字符串是 0b0c0b0。
用 1 代替 b。现在字符串是 010c010。
用 1 代替 c。现在字符串是 0101010。这是一个交替的二进制字符串。
†一个交替的二进制字符串是一个由 0 和 1 组成的字符串，这样相邻的两个比特都不相等。例如，01010101、101、1 是交替的二进制字符串，而 0110、0a0a0、10100 不是。

奇数和偶数分别统计 K->V。同一个字母不能同时存在两个 Set 中。
======

input
8
7
abacaba
2
aa
1
y
4
bkpt
6
ninfia
6
banana
10
codeforces
8
testcase
output
YES
NO
YES
YES
NO
YES
NO
NO
 */
