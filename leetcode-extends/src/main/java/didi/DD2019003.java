package didi;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class DD2019003 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            v[i] = scanner.nextInt();
        }
        System.out.println(solve(n, m, v));
    }

    private static String solve(int n, int m, int[] v) {
        int min = 0;
        long sum = 0;
        for (int vi : v) {
            min = Math.min(min, vi);
            sum += vi;
        }

        long left = min;
        long right = sum + 1;
        while (left < right) {
            long mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (!checkMid(n, m, v, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return String.valueOf(left - 1);
    }

    private static boolean checkMid(int n, int m, int[] v, long mid) {
        long cur = 0;
        int left = 0;
        while (left < n) {
            cur = v[left];
            int right = left + 1;
            while (right < n && cur < mid) {
                if (m <= 0) {
                    return false;
                }
                cur += v[right];
                right++;
                m--;
            }
            left = right;
        }
        if (cur >= mid) {
            return true;
        }
        return m >= 1;
    }
}
/*
DD-2019003. 魔法权杖强化
https://leetcode.cn/problems/Xa2zdh/

有一把魔法权杖，权杖上有 n 颗并排的法术石(编号为 1 到 n)。每颗法术石具有一个能量值，权杖的法术强度等同于法术石的最小能量值。
权杖可以强化，一次强化可以将两颗相邻的法术石融合为一颗，融合后的能量值为这两颗法术石能量值之和。现在有 m 次强化的机会，请问权杖能 强化到的最大法术强度是多少？
格式：
输入：
- 第一行包含两个正整数 n，m，表示 n 颗法术石，m 次强化机会。
- 第二行为 n 个用空格隔开的正整数 v_1, v_2, ... , v_n，v_i 表示编号为 i 的法术石具有的能量值。
输出：
- 输出 1 个整数，表示权杖的最大的法术强度。
示例：
输入：
6 3
1 7 2 2 5 9
输出：8
提示：
1 ≤ m < n ≤ 100000，1 ≤ v_i ≤ 100000

二分
 */