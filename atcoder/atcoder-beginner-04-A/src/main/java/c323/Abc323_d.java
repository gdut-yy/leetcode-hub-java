package c323;

import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Abc323_d {
    static int n;
    static TreeMap<Long, Long> sc;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        sc = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            long s = scanner.nextLong();
            long c = scanner.nextLong();
            sc.put(s, c);
        }
        System.out.println(solve());
    }

    private static String solve() {
        long ans = 0;
        while (!sc.isEmpty()) {
            Map.Entry<Long, Long> entry = sc.firstEntry();
            long s = entry.getKey(), c = entry.getValue();
            ans += c % 2;
            long ns = s * 2;
            long nc = c / 2 + sc.getOrDefault(ns, 0L);
            sc.remove(s);
            if (nc > 0) {
                sc.put(ns, nc);
            }
        }
        return String.valueOf(ans);
    }
}
/*
D - Merge Slimes
https://atcoder.jp/contests/abc323/tasks/abc323_d

题目大意：
最初，有 N 种大小的黏菌。
具体来说，对于每一个 1≤i≤N，有 ci 个大小为 si 的黏液。
高桥可以以任何顺序重复黏液合成任何次数(可能为零)。
黏液的合成步骤如下。
- 选择两个相同大小的黏液。设这个黏液大小为 X，就会出现一个新的黏液大小为 2X。然后，原来的两个黏液消失了。
高桥希望尽量减少黏菌的数量。通过最优的合成序列，他最终能得到的黏液的最小数量是多少?

贪心，平衡树。从小的开始合并
======

Input 1
3
3 3
5 1
6 1
Output 1
3

Input 2
3
1 1
2 1
3 1
Output 2
3

Input 3
1
1000000000 1000000000
Output 3
13
 */
