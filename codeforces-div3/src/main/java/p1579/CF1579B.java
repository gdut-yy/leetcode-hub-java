package p1579;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CF1579B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = scanner.nextInt();
            }

            List<String> res = solve(n, a);
            System.out.println(res.size());
            for (String re : res) {
                System.out.println(re);
            }
        }
    }

    private static List<String> solve(int n, int[] a) {
        int[] sorted = a.clone();
        Arrays.sort(sorted);

        List<String> resList = new ArrayList<>();
        // sorted[i]
        for (int i = 0; i < n; i++) {
            // a[j]
            for (int j = i; j < n; j++) {
                if (a[j] == sorted[i]) {
                    if (j != i) {
                        shift(a, i, j, j - i);
                        resList.add((i + 1) + " " + (j + 1) + " " + (j - i));
                    }
                    break;
                }
            }
        }
        return resList;
    }

    private static void shift(int[] a, int l, int r, int d) {
        int len = r - l + 1;
        int[] copy = new int[len];
        for (int i = 0; i < len; i++) {
            copy[i] = a[l + i];
        }
        for (int i = 0; i < len; i++) {
            a[l + i] = copy[(i + d) % len];
        }
    }
}
/*
B. Shifting Sort
https://codeforces.com/contest/1579/problem/B

题目大意：
给出字符串 s。s 只包含 'A','B','C' 三种字符，每次操作可去除 1个'A'和 1个'B'，或去除 1个'B'和 1个'C'，问最后能否成为空串。

统计字符频次，判断 'B'的频次是否等于 'A','C'频次之和即可。
======
 */