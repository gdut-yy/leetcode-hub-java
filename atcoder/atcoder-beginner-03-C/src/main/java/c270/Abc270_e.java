package c270;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Abc270_e {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        long k = scanner.nextLong();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
        }
        System.out.println(solve(n, k, a));
    }

    // 方法一 https://atcoder.jp/contests/abc270/editorial/4883
    private static String solve(int n, long k, long[] a) {
        long left = 0;
        long right = (long) 1e12;
        while (left < right) {
            long mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (!checkMid(n, k, a, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        for (int i = 0; i < n; i++) {
            long d = Math.min(left - 1, a[i]);
            a[i] -= d;
            k -= d;
        }

        for (int i = 0; k > 0; i++) {
            if (a[i] > 0) {
                a[i]--;
                k--;
            }
        }
        return Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }

    private static boolean checkMid(int n, long k, long[] a, long mid) {
        long s = 0L;
        for (int i = 0; i < n; i++) {
            s += Math.min(mid, a[i]);
        }
        return s <= k;
    }

    // 方法二
    private static String solve1(int n, long k, long[] a) {
        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
        }
        Arrays.sort(ids, Comparator.comparingLong(o -> a[o]));

        long s = 0L;
        for (int id : ids) {
            long d = a[id] - s;
            if (d > 0) {
                if (k <= d * n) {
                    // 剩下所有苹果，每个至少吃 k/n 个
                    s += k / n;
                    // 有 k 个苹果要多吃一个
                    k %= n;
                    break;
                }
                // 吃掉所有 >= s 的苹果
                s += d;
                k -= d * n;
            }
            n--;
        }

        List<Long> resList = new ArrayList<>();
        for (long v : a) {
            if (v <= s) {
                v = 0;
            } else {
                v -= s;
                if (k > 0) {
                    v--;
                    k--;
                }
            }
            resList.add(v);
        }
        return resList.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
E - Apple Baskets on Circle
https://atcoder.jp/contests/abc270/tasks/abc270_e

灵茶の试炼 2023-01-30
题目大意：
输入 n(≤1e5) k(≤1e12) 和长为 n 的数组 a(0≤a[i]≤1e12, sum(a)≥k)
有 n 堆苹果顺时针围成一圈，第 i 堆有 a[i] 个苹果。
你从第一堆苹果开始吃，每堆吃了一个苹果后，就顺时针走到下一个还有苹果的堆，重复该过程，直到吃了 k 个苹果。
输出此时每堆剩余苹果数。
你能想出两种不同的做法吗？

https://atcoder.jp/contests/abc270/submissions/38448191
方法一：二分 O(nlogk)
二分最多可以完整地吃多少圈。
check 吃 mid 圈，如果吃的苹果超过 k 说明 mid 大了，否则说明 mid 小了。
二分出结果后，最后一圈手动模拟。
方法二：排序 O(nlogn)
想一想，每一圈吃的苹果个数 b，在何时会减少？
不去一圈圈模拟，而是在 b 减少的时候，才去计算又吃了多少苹果。
具体见代码，有注释。
======

Input
3 3
1 3 0
Output
0 1 0

Input
2 1000000000000
1000000000000 1000000000000
Output
500000000000 500000000000
 */