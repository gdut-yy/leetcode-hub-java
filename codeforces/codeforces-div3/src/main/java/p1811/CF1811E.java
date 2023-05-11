package p1811;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1811E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            long k = scanner.nextLong();
            System.out.println(solve(k));
        }
    }

    private static String solve(long k) {
        String s = Long.toString(k, 9);
        // 4 -> 5
        // 5 -> 6
        // 6 -> 7
        // 7 -> 8
        // 8 -> 9
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] >= '4') {
                cs[i]++;
            }
        }
        return new String(cs);
    }
}
/*
E. Living Sequence
https://codeforces.com/contest/1811/problem/E

题目大意：
在日本，数字 4 读起来像死亡，所以鲍勃决定建立一个现场序列。
活数列 a 包含所有不包含数字 4 的自然数。=[1, 2, 3, 5, 6, 7, 8, 9, 10, 11, 12 日,13 日,15 日,16 日…]。
例如，数字 1235 是数列 a 的一部分，但数字 4321 和 443 不属于数列 a。
Bob 意识到他不知道如何通过序列中 k 的位置快速搜索特定的数字，所以他向您寻求帮助。
例如，如果 Bob 想要找到位置 k=4 的数字(从 1 开始索引)，您需要回答 ak=5。

10 进制转 9 进制后：
0 1 2 3 4 5 6 7 8
映射为
0 1 2 3 5 6 7 8 9
======

input
7
3
5
22
10
100
12345
827264634912
output
3
6
25
11
121
18937
2932285320890
 */
