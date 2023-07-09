package c306;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Abc306_c {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int[] a = new int[n * 3];
        for (int i = 0; i < n * 3; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve(n, a));
    }

    private static String solve(int n, int[] a) {
        List<List<Integer>> idsList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            idsList.add(new ArrayList<>());
        }
        for (int i = 0; i < n * 3; i++) {
            idsList.get(a[i] - 1).add(i);
        }

        // 按 中间位置的索引 升序排序
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            treeMap.put(idsList.get(i).get(1), i + 1);
        }
        return treeMap.values().stream().map(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
C - Centers
https://atcoder.jp/contests/abc306/tasks/abc306_c

题目大意：
给定一个长度为 3N 的序列 a =(a1,a2,...,a3N)，其中 1,2,...,N 中的每一个恰好出现三次。
对于 i=1,2,...,N，设 f(i)为 i 在 a 中出现的中间位置的索引，对 f(i)按升序排序 1,2,...,N。
形式上，f(i)定义如下:
假设满足 Aj=i 的 j 是 j=α,β,γ (α<β<γ)。然后,f(i) =β。

模拟
======

Input 1
3
1 1 3 2 3 2 2 3 1
Output 1
1 3 2

Input 2
1
1 1 1
Output 2
1

Input 3
4
2 3 4 3 4 1 3 1 1 4 2 2
Output 3
3 4 1 2
 */