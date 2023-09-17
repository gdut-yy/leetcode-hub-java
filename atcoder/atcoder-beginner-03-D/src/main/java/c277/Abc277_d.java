package c277;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.TreeMap;

public class Abc277_d {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve(n, m, a));
    }

    private static String solve(int n, int m, int[] a) {
        long sum = 0L;
        // remain
        TreeMap<Integer, Long> map = new TreeMap<>();
        for (int x : a) {
            sum += x;
            int remain = x % m;
            map.put(remain, map.getOrDefault(remain, 0L) + x);
        }

        long max = 0L;
        for (Integer key = map.firstKey(); key != null; key = map.higherKey(key)) {
            max = Math.max(max, map.get(key));
            if (map.containsKey(key + 1)) {
                map.put(key + 1, map.get(key + 1) + map.get(key));
                map.put(key, 0L);
                max = Math.max(max, map.get(key + 1));
            }
        }
        // 两遍松弛
        if (map.lastKey() == m - 1) {
            map.put(-1, map.get(m - 1));
            map.put(m - 1, 0L);
        }
        for (Integer key = map.firstKey(); key != null; key = map.higherKey(key)) {
            if (map.containsKey(key + 1)) {
                map.put(key + 1, map.get(key + 1) + map.get(key));
                map.put(key, 0L);
                max = Math.max(max, map.get(key + 1));
            }
        }
        return String.valueOf(sum - max);
    }
}
/*
D - Takahashi's Solitaire
https://atcoder.jp/contests/abc277/tasks/abc277_d

题目大意：
高桥手里有 N 张牌。对于 i=1,2，…，N，第 i 张牌上写着一个非负整数 Ai。
首先，高桥将自由地从他的手牌中选择一张牌并将其放在桌子上。然后，他将尽可能多地重复下面的操作(可能为零)。
- 设 X 是写在桌子上最后一张牌上的整数。如果他手上的牌上写着整数 X 或整数(X+1)modM，你可以自由地从这些牌中选择一张并把它放在桌上。这里，(X+1)modM 表示(X+1)除以 M 时的余数。
打印出最后留在他手中的卡片上的整数的尽可能小的和。

TreeMap 模拟
相似题目: 846. 一手顺子
https://leetcode.cn/problems/hand-of-straights/
======

Input 1
9 7
3 0 2 5 5 3 0 6 3
Output 1
11

Input 2
1 10
4
Output 2
0

Input 3
20 20
18 16 15 9 8 8 17 1 3 17 11 9 12 11 7 3 2 14 3 12
Output 3
99
 */