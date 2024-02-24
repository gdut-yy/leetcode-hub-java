package p847;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF847E {
    static int n;
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        s = scanner.next().toCharArray();
        System.out.println(solve());
    }

    static List<Integer> a, b;

    private static String solve() {
        a = new ArrayList<>();
        b = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (s[i] == 'P') a.add(i);
            else if (s[i] == '*') b.add(i);
        }

        int left = 0;
        int right = n * 2;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return String.valueOf(left);
    }

    static boolean checkMid(int t) {
        int i = 0;
        for (Integer x : a) {
            int y = b.get(i);
            if (x - y > t) {
                return false;
            }
            if (y - x > t) {
                continue;
            }
            int r = x + t;
            if (y < x) {
                r = Math.max(t + y * 2 - x, (t + y + x) / 2);
            }
            while (b.get(i) <= r) {
                if (++i == b.size()) {
                    return true;
                }
            }
        }
        return false;
    }
}
/*
E. Packmen
https://codeforces.com/contest/847/problem/E

灵茶の试炼 2022-06-16
题目大意：
给你一个整数 n(<=1e5) 和一个长为 n 的字符串 s（包含 P*. 三种字符，其中 'P' 表示动物，'*' 表示食物，'.' 表示空地）。
所有动物每单位时间均能移动一个单位，动物移动到食物上就会吃掉食物，吃掉食物的时间忽略不计。
所有动物可以一起移动。请问吃掉所有食物最少需要多少时间。

rating 1800
https://codeforces.com/contest/847/submission/160783663
二分答案，设为 t，判断 t 时间内能否吃掉所有食物。
从左往右遍历动物位置 x 和未被吃的食物位置 y（用另一个指针维护）：
1. 如果动物左侧没有食物，那么它可以吃掉 [x,x+t] 范围内的食物；
2. 如果动物左侧还有食物，那么它可以先左后右移动，也可以先右后左移动，根据 y 可以计算出这两种哪个可以让它往右移动最远（具体公式见代码）。
注意二分上界至少是 3n/2。（我写的 2n）
======

input
7
*..P*P*
output
3

input
10
.**PP.*P.*
output
2
 */
