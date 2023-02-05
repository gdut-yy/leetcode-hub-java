package c287;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Abc287_b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = scanner.next();
        }
        Set<String> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            String t = scanner.next();
            set.add(t);
        }
        int res = 0;
        for (String x : s) {
            String sub = x.substring(3);
            if (set.contains(sub)) {
                res++;
            }
        }
        System.out.println(res);
    }
}
/*
B - Postal Card
https://atcoder.jp/contests/abc287/tasks/abc287_b
 */