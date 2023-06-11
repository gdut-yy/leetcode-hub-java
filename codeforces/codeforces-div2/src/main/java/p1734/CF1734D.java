package p1734;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CF1734D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve(n, k, a));
        }
    }

    private static long h;

    // https://codeforces.com/contest/1734/submission/173201855
    private static String solve(int n, int k, int[] a) {
        k--;
        h = a[k];

        // 预处理右半部分
        int[] right = Arrays.copyOfRange(a, k + 1, n);
        List<long[]> r = f(right);
        // 预处理左半部分
        int[] left = Arrays.copyOfRange(a, 0, k);
        reverse(left);
        List<long[]> l = f(left);

        int i = 0, j = 0, szL = l.size(), szR = r.size();
        while (i < szL && j < szR) {
            if (h + l.get(i)[0] >= 0) {
                h += l.get(i)[1];
                i++;
                continue;
            }
            if (h + r.get(j)[0] >= 0) {
                h += r.get(j)[1];
                j++;
                continue;
            }
            return "NO";
        }
        return "YES";
    }

    private static void reverse(int[] a) {
        int n = a.length;
        for (int i = 0; i < n / 2; i++) {
            int tmp = a[i];
            a[i] = a[n - 1 - i];
            a[n - 1 - i] = tmp;
        }
    }

    private static List<long[]> f(int[] a) {
        List<long[]> res = new ArrayList<>();
        int n = a.length;
        int i = 0;
        while (i < n) {
            if (a[i] > 0) h += a[i];
            else break;
            i++;
        }

        while (i < n) {
            long neg = 0, minNeg = 0;
            while (true) {
                while (i < n && a[i] < 0) {
                    neg += a[i];
                    i++;
                }
                minNeg = Math.min(minNeg, neg);
                if (i == n) {
                    res.add(new long[]{minNeg, neg});
                    break;
                }

                long pos = 0;
                while (i < n && a[i] > 0) {
                    pos += a[i];
                    i++;
                }
                if (neg + pos > 0) {
                    res.add(new long[]{minNeg, neg + pos});
                    break;
                }
                neg += pos;
            }
        }
        return res;
    }
}
/*
D. Slime Escape
https://codeforces.com/contest/1734/problem/D

题目大意：
你正在玩一款名为 Slime Escape 的游戏。游戏在数轴上进行。最初，有 n 个黏菌。对于 1≤i≤n 的所有正整数 i，第 i 个黏液位于位置 i，其健康度为 ai。你在控制位置 k 的粘液。
有两个转义位于位置 0 和 n+1。你的目标是通过执行任意数量的游戏移动到达两个逃脱中的任何一个。
在一个游戏移动中，你将黏液向左或向右移动一个位置。但是，如果在新位置有另一种黏液，则必须将其吸收。当你吸收黏液时，黏液的生命值会随着被吸收黏液的生命值而增加，然后被吸收的黏液会从游戏中移除。
请注意，一些黏液可能有负面健康，所以当你吸收这些黏液时，你的健康会下降。
如果你的黏液在游戏中的任何时刻都有负生命值，你将立即输掉游戏。
你能否在不输掉游戏的情况下，通过执行任意数量的游戏移动到达两个逃生点中的一个?

贪心。
1.把所有加血和扣血的都合并起来
2.把相邻的一对（负数，正数） 看成一组，就是先掉血，再加血
3.如果掉的血大于加的血，那么直接合并，看成是掉血
4.在合并的时候，把扣血（负数） 的最小值（也就是扣的最多的血）记录下来
5.后面贪心去取左/右的时候，先看一下当前血量扣的最多的血能不能还是非负，能的话就先扣血再加血
======

input
6
7 4
-1 -2 -3 6 -2 -3 -1
3 1
232 -500 -700
7 4
-1 -2 -4 6 -2 -4 -1
8 4
-100 10 -7 6 -2 -3 6 -10
8 2
-999 0 -2 3 4 5 6 7
7 3
7 3 3 4 2 1 1
output
YES
YES
NO
YES
NO
YES
 */
