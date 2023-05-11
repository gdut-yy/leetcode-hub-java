package p1822;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1822D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            System.out.println(solve(n));
        }
    }

    private static String solve(int n) {
        if (n == 1) {
            return "1";
        }
        if ((n & 1) == 1) {
            return "-1";
        }
        int[] res = new int[n];
        res[0] = n;
        for (int i = 1; i < n; i += 2) {
            res[i] = n - i;
        }
        for (int i = 2; i < n; i += 2) {
            res[i] = i;
        }
        return Arrays.stream(res).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
D. Super-Permutation
https://codeforces.com/contest/1822/problem/D

题目大意：
列是一个 n 个整数的序列，其中从 1 到 n 的每个整数只出现一次。例如，[1]，[3,5,2,1,4]，[1,3,2]是排列，而[2,3,2]，[4,3,1]，[0]不是排列。
给定一个排列 a，构造一个数组 b，其中 bi=(a1+a2+...ai)mod n。
如果[b1+1,b2+1,...,bn+1]也是长度为 n 的排列，则数字[a1,a2,...,an]的排列称为超级排列。
Grisha 开始对长度为 n 的超排列是否存在感兴趣。帮他解决这个重要的问题。输出任意长度为 n 的超排列(如果存在)。否则输出 −1。

找规律。第一个数需要为 n，然后每对数的和都是 n+1。
======

input
4
1
2
3
6
output
1
2 1
-1
6 5 2 3 4 1
 */
