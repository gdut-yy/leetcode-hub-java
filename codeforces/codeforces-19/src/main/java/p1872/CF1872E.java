package p1872;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1872E {
    static int n;
    static int[] a;
    static char[] cs;
    static int q;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            int[] preSum = new int[n + 1];
            for (int i = 0; i < n; i++) {
                preSum[i + 1] = preSum[i] ^ a[i];
            }
            cs = scanner.next().toCharArray();
            int ans0 = 0, ans1 = 0;
            for (int i = 0; i < n; i++) {
                if (cs[i] == '0') {
                    ans0 ^= a[i];
                } else {
                    ans1 ^= a[i];
                }
            }
            q = scanner.nextInt();
            List<Integer> ans = new ArrayList<>();
            for (int qi = 0; qi < q; qi++) {
                int op = scanner.nextInt();
                if (op == 1) {
                    int l = scanner.nextInt();
                    int r = scanner.nextInt();
                    int xor = preSum[r] ^ preSum[l - 1];
                    ans0 ^= xor;
                    ans1 ^= xor;
                } else {
                    int g = scanner.nextInt();
                    if (g == 0) {
                        ans.add(ans0);
                    } else {
                        ans.add(ans1);
                    }
                }
            }
            String output = ans.stream().map(String::valueOf).collect(Collectors.joining(" "));
            System.out.println(output);
        }
    }
}
/*
E. Data Structures Fan
https://codeforces.com/contest/1872/problem/E

题目大意：
给定一个整数数组 a1,a2,...,an，以及一个由 n 个字符组成的二进制字符串†s。
奥古斯丁是数据结构的忠实粉丝。因此，他要求您实现一个可以回答 q 查询的数据结构。查询有两种类型:
- "1 l r"(1≤l≤r≤n) -将 l≤i≤r 的每个字符 si 替换为它的反数。也就是说，将所有 0 替换为 1，将所有 1 替换为 0。
- "2 g"(g∈{0,1})-计算所有索引 i 的数字 ai 的按位异或值，使 si=g。注意，空数字集的异或被认为等于 0。
请帮助奥古斯丁回答所有的问题!
例如，如果 n=4, a=[1,2,3,6], s=1001，考虑以下一系列查询:
- "2 0" 我们对 si=0 的索引 i 感兴趣，因为 s=1001，这些是索引 2 和 3，所以查询的答案将是 a2⊕a3=2⊕3=1。
- "1 1 3" 我们需要用字符 s1,s2,s3 的反义词替换字符 s1,s2,s3，因此在查询 s=1001 之前，在查询 s=0111 之后。
- "2 1 1" 我们对 si=1 的索引 i 感兴趣，因为 s=0111，这些是索引 2、3 和 4，所以查询的答案将是 a2⊕a3⊕a4=2⊕3⊕6=7。
- "1 2 4" s=0111→s=0000。
- "2 1" s=0000，没有 si=1 的索引，因此由于空数字集的异或被认为等于 0，因此该查询的答案为 0。
†二进制字符串是只包含字符 0 或 1 的字符串。

异或性质 + 前缀异或
======

input
5
5
1 2 3 4 5
01000
7
2 0
2 1
1 2 4
2 0
2 1
1 1 3
2 1
6
12 12 14 14 5 5
001001
3
2 1
1 2 4
2 1
4
7 7 7 777
1111
3
2 0
1 2 3
2 0
2
1000000000 996179179
11
1
2 1
5
1 42 20 47 7
00011
5
1 3 4
1 1 1
1 3 4
1 2 4
2 0
output
3 2 6 7 7
11 7
0 0
16430827
47
 */
