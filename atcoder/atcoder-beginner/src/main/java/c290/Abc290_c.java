package c290;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Abc290_c {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve(k, a));
    }

    private static String solve(int k, int[] a) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int x : a) {
            treeSet.add(x);
        }
        Set<Integer> set = new HashSet<>();
        if (treeSet.size() > k) {
            for (int i = 0; i < k; i++) {
                set.add(treeSet.pollFirst());
            }
        } else {
            set.addAll(treeSet);
        }

        int sz = set.size();
        for (int i = 0; i <= sz; i++) {
            if (!set.contains(i)) {
                return String.valueOf(i);
            }
        }
        return "-1";
    }
}
/*
C - Max MEX
https://atcoder.jp/contests/abc290/tasks/abc290_c

题目大意：
给定一个长度为- N 的非负整数序列。
当 B 是从 a 中选取 K 个元素，不改变顺序将它们串联得到的序列时，求 MEX(B)的最大可能值。
这里，对于序列 X，我们定义 MEX(X)为唯一的非负整数 m，满足以下条件:
- X 中包含 0≤i<m 的每一个整数 i。
- m 不包含在 X 中。

相似题目: 2003. 每棵子树内缺失的最小基因值
https://leetcode.cn/problems/smallest-missing-genetic-value-in-each-subtree/
======

Input 1
7 3
2 0 2 3 2 1 9
Output 1
3
 */