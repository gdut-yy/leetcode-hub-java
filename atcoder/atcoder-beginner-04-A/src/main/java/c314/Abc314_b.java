package c314;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Abc314_b {
    static int n, x;
    static int[] c;
    static long[] mask;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        c = new int[n + 1];
        mask = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            c[i] = scanner.nextInt();
            for (int j = 0; j < c[i]; j++) {
                int a = scanner.nextInt();
                mask[i] |= 1L << a;
            }
        }
        x = scanner.nextInt();
        System.out.println(solve());
    }

    private static String solve() {
        int min = 64;
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if ((mask[i] >> x & 1) == 1) {
                if (min > c[i]) {
                    min = c[i];
                    ans.clear();
                    ans.add(i);
                } else if (min == c[i]) {
                    ans.add(i);
                }
            }
        }

        return ans.size() + System.lineSeparator()
                + ans.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
B - Roulette
https://atcoder.jp/contests/abc314/tasks/abc314_b

题目大意：
N 个人, 1 号, 2 号,..., N 号，玩轮盘赌。自旋的结果是从 0 到 36 的 37 个整数中的一个。对于每个 i=1,2,...,N，第 i 个人在 37 种可能的结果中押注 Ci: Ai,1,Ai,2,...,Ai,Ci。
转盘已经转动，结果是 X。将所有下注最少的人在 X 上下注的人数按升序打印出来。
更正式地，按升序打印 1 到 N 之间的所有整数 i，包括满足以下两个条件的整数 i:
第 i 个人赌 X。
对于每一个 j=1,2,...,N，如果 j 对 X 下注，那么 i≤jc。
注意，可能没有要打印的数字(参见示例输入 2)。
---
轮子已经转动了，结果是 19。赌 19 的人分别是人 1、人 2 和人 4，他们下注的次数分别是 3、4 和 3。因此，在下注 19 的人中，下注最少的是第 1 人和第 4 人。

最大只有 37 个数，bitmask 一下
======

Input 1
4
3
7 19 20
4
4 19 24 0
2
26 10
3
19 31 24
19
Output 1
2
1 4

Input 2
3
1
1
1
2
1
3
0
Output 2
0
 */