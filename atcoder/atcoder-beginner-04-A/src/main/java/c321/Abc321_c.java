package c321;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Abc321_c {
    static int k;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        k = scanner.nextInt();
        System.out.println(solve());
    }

    private static final int N = 10;

    private static String solve() {
        List<Long> ans = new ArrayList<>();
        for (int mask = 1; mask < 1 << N; mask++) {
            long x = 0;
            for (int j = N - 1; j >= 0; j--) {
                if ((mask >> j & 1) == 1) {
                    x = x * 10 + j;
                }
            }
            ans.add(x);
        }
        ans.sort(null);
        return String.valueOf(ans.get(k));
    }
}
/*
C - 321-like Searcher
https://atcoder.jp/contests/abc321/tasks/abc321_c

题目大意：
当正整数 x 满足以下条件时，称为类 321 数。这个定义与问题 a 中的定义相同，
- x 的数字从上到下严格递减。换句话说，
- 如果 x 有 d 位数字，那么对于每一个整数 i，它满足以下条件，
  - 使得 1≤i<d:(x 的第 i 位数字)> (x 的第 i+1)位数字)。
注意，所有的一位数正整数都是类 321 数。
例如，321、96410 和 1 是类似 321 的数字，而 123、2109 和 86411 不是。
求第 k 个最小的 321 类数。

状态压缩，最多只会有 2^10 - 2 = 1022 个数（除去空集 和 0）
======

Input 1
15
Output 1
32

Input 2
321
Output 2
9610

Input 3
777
Output 3
983210
 */
