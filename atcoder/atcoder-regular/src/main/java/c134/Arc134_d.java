package c134;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Arc134_d {
    static int n;
    static int[] A;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        A = new int[n * 2];
        for (int i = 0; i < n * 2; i++) {
            A[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int[] a = new int[n];
        int[] b = new int[n];
        int lenA = 0, lenB = 0;
        for (int i = 0; i < n; i++) {
            int x = A[i], y = A[i + n];
            while (lenA > 0 && x < a[lenA - 1]) {
                lenA--;
                lenB--;
            }
            a[lenA++] = x;
            b[lenB++] = y;
        }

        int i = upperBound(a, lenA, a[0]);
        int mn = b[0];
        for (int j = 0; j < i; j++) {
            mn = Math.min(mn, b[j]);
        }
        if (mn <= a[0]) {
            return a[0] + " " + mn;
        }

        int l = lowerBound(a, lenA, b[0]);
        int r = upperBound(a, lenA, b[0]);

        // print(*min(a[:l] + b[:l], a[:r] + b[:r]))
        List<Integer> ll = new ArrayList<>();
        List<Integer> rr = new ArrayList<>();
        for (int j = 0; j < l; j++) ll.add(a[j]);
        for (int j = 0; j < l; j++) ll.add(b[j]);
        for (int j = 0; j < r; j++) rr.add(a[j]);
        for (int j = 0; j < r; j++) rr.add(b[j]);
        String ans1 = ll.stream().map(String::valueOf).collect(Collectors.joining(" "));
        String ans2 = rr.stream().map(String::valueOf).collect(Collectors.joining(" "));
//        List<Integer> ans = new ArrayList<>();
//        for (int j = 0; j < Math.max(ll.size(), rr.size()); j++) {
//            ans.add(Math.min(j < ll.size() ? ll.get(j) : Integer.MAX_VALUE, j < rr.size() ? rr.get(j) : Integer.MAX_VALUE));
//        }
//        for (int j = 0; j < ll.size(); j++) {
//            ans.add(Math.min(ll.get(j), rr.get(j)));
//        }
//        return ans.stream().map(String::valueOf).collect(Collectors.joining(" "));
        return ans1.compareTo(ans2) < 0 ? ans1 : ans2;
    }

    static int lowerBound(int[] a, int len, int key) {
        int l = 0, r = len;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a[m] >= key) r = m;
            else l = m + 1;
        }
        return l;
    }

    static int upperBound(int[] a, int len, int key) {
        int l = 0, r = len;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a[m] > key) r = m;
            else l = m + 1;
        }
        return l;
    }
}
/*
D - Concatenate Subsequences
https://atcoder.jp/contests/arc134/tasks/arc134_d

灵茶の试炼 2023-10-26
题目大意：
输入 n(1≤n≤1e5) 和长为 2n 的数组 A(1≤a[i]≤1e9)。
你需要从 A 的前 n 个数中删除一些数，删除 A[i] 会把 A[i+n] 也一并删除。
你不能把整个数组都删掉。
设删除后的数组为 A'。
输出字典序最小的 A'。

https://www.luogu.com.cn/blog/endlesscheng/solution-at-arc134-d
======

Input 1
3
2 1 3 1 2 2
Output 1
1 2

Input 2
10
38 38 80 62 62 67 38 78 74 52 53 77 59 83 74 63 80 61 68 55
Output 2
38 38 38 52 53 77 80 55

Input 3
12
52 73 49 63 55 74 35 68 22 22 74 50 71 60 52 62 65 54 70 59 65 54 60 52
Output 3
22 22 50 65 54 52
 */