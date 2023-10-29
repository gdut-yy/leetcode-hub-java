package p1878;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1878B {
    static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            System.out.println(solve());
        }
    }

    private static String solve() {
        int[] a = new int[n];
        a[0] = 1;
        for (int i = 1; i < n; i++) {
            a[i] = a[i - 1] + 2;
        }
        return Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
B. Aleksa and Stack
https://codeforces.com/contest/1878/problem/B

题目大意：
塞尔维亚信息学奥林匹克竞赛结束后，阿列克谢非常伤心，因为他没有赢得奖牌(他不知道堆栈)，所以瓦西里耶来给他一个简单的问题，只是为了让他的日子好过一些。
Vasilije 给 Aleksa 一个正整数 n (n≥3)，并要求他构造一个大小为 n 的正整数严格递增数组，这样
- 对于每个 i(1≤i≤n-2)， 3·a[i+2] 不能被 a[i]+a[i+1] 整除。
请注意，大小为 n 的严格递增数组 a 对于每个 i(1≤i≤n - 1)都是一个 ai<ai+1 的数组。
由于阿列克萨认为他现在是一个糟糕的程序员，他让你帮他找到这样一个数组。

全为奇数即可
奇 + 奇 = 偶
奇 * 3 = 奇
======

input
3
3
6
7
output
6 8 12
7 11 14 20 22 100
9 15 18 27 36 90 120
 */
