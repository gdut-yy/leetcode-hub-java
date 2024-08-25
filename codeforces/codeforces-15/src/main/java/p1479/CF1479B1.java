package p1479;

import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class CF1479B1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve(n, a));
    }

    private static String solve(int n, int[] a) {
        List<Deque<Integer>> pos = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            pos.add(new ArrayDeque<>());
        }

        for (int i = 0; i < n; i++) {
            pos.get(a[i]).add(i);
        }
        for (int i = 0; i < n + 1; i++) {
            pos.get(i).add(n);
        }

        List<Integer> s = new ArrayList<>(List.of(0));
        List<Integer> t = new ArrayList<>(List.of(0));
        for (int v : a) {
            int lastS = s.get(s.size() - 1), lastT = t.get(t.size() - 1);
            if (v == lastT || v != lastS && pos.get(lastS).getFirst() < pos.get(lastT).getFirst()) {
                s.add(v);
            } else {
                t.add(v);
            }
            pos.get(v).removeFirst();
        }

        int ans = 0;
        for (int i = 1; i < s.size(); i++) {
            if (!Objects.equals(s.get(i), s.get(i - 1))) {
                ans++;
            }
        }
        for (int i = 1; i < t.size(); i++) {
            if (!Objects.equals(t.get(i), t.get(i - 1))) {
                ans++;
            }
        }
        return String.valueOf(ans);
    }
}
/*
B1. Painting the Array I
https://codeforces.com/contest/1479/problem/B1

灵茶の试炼 2023-05-04
题目大意：
输入 n(1≤n≤1e5) 和长为 n 的数组 a(1≤a[i]≤n)。
从 a 中选择一个子序列 A，剩余元素作为另一个子序列 B。
定义 f(C) 表示对序列 C 不断去掉相邻相同元素，直到没有相邻相同元素为止，返回剩余元素的个数。
例如 f([1,1,2,1,1]) = f([1,2,1]) = 3。
输出 f(A) + f(B) 的最大值。
变形（这场的 B2）：输出 f(A) + f(B) 的最小值。

rating 1900
https://codeforces.com/problemset/submission/1479/204384720
想象成往两个数组 s 和 t 的末尾不断添加元素。
为方便计算，初始时 s 和 t 中都添加一个 0。
如果 a[i] 与 s、t 的末尾元素都相同，那么加到哪个数组末尾都是一样的。
如果 a[i] 与 t 的末尾元素相同，那么加到 s 末尾。
如果 a[i] 与 s 的末尾元素相同，那么加到 t 末尾。
如果 a[i] 与 s、t 的末尾元素都不相同，例如 s 末尾为 1，t 末尾为 2，a[i]=3，此时应考察下一个 1 以及下一个 2 的位置，哪个位置更近，就加到哪个数组末尾（如果没有下一个元素就视作 n+1）。
例如下一个 1 的位置更近，那么应当把 a[i] 加到 s 末尾，相当于把这两个 1 隔开；至于 t，后面还有机会把 t 末尾的 2 和下一个 2 隔开。更严谨的证明见右边链接。
https://codeforces.com/blog/entry/87598
======

input
7
1 1 2 2 3 3 3
output
6

input
7
1 2 3 4 5 6 7
output
7
 */
