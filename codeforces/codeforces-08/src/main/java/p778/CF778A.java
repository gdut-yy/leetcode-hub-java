package p778;

import java.util.Scanner;

public class CF778A {
    static char[] b, a;
    static int nb;
    static int[] id;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        b = scanner.next().toCharArray();
        a = scanner.next().toCharArray();
        nb = b.length;
        id = new int[nb];
        for (int i = 0; i < nb; i++) {
            id[i] = scanner.nextInt() - 1;
        }
        System.out.println(solve());
    }

    private static String solve() {
        int left = 0;
        int right = nb;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return String.valueOf(left - 1);
    }

    static boolean checkMid(int p) {
        boolean[] used = new boolean[nb];
        for (int i = 0; i < p; i++) {
            used[id[i]] = true;
        }
        StringBuilder c = new StringBuilder();
        for (int i = 0; i < nb; i++) {
            if (!used[i]) {
                c.append(b[i]);
            }
        }
        int i = 0, n = a.length;
        int j = 0, m = c.length();
        while (true) {
            if (i == n) return false;
            if (j == m) return true;
            if (a[i] == c.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }
    }
}
/*
A. String Game
https://codeforces.com/contest/778/problem/A

灵茶の试炼 2022-05-12
题目大意：
给你两个字符串 s 和 t（保证 t 是 s 的子序列），s 由小写字母组成，长度不超过 2e5。
再给你一个由 s 的所有下标组成的排列 p，设 p 的长为 x 的前缀为 p[:x]，你需要从 s 中删掉所有下标在 p[:x] 中的字符，得到字符串 s'。
输出满足 t 为 s' 的子序列的最大的 x。
注意子序列不要求连续。

rating 1700
https://codeforces.com/contest/778/submission/88660596
二分答案
======

input
ababcba
abb
5 3 4 1 7 6 2
output
3

input
bbbabb
bb
1 6 3 4 2 5
output
4
 */
