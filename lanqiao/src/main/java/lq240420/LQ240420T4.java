package lq240420;

import java.util.Scanner;

public class LQ240420T4 {
    static int lenN, lenL, lenR;
    static int[] N, L, R;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        lenN = scanner.nextInt();
        N = new int[lenN + 1];
        for (int i = 1; i <= lenN; i++) {
            N[i] = scanner.nextInt();
        }
        lenL = scanner.nextInt();
        L = new int[lenL + 1];
        for (int i = 1; i <= lenL; i++) {
            L[i] = scanner.nextInt();
        }
        lenR = scanner.nextInt();
        R = new int[lenR + 1];
        for (int i = 1; i <= lenR; i++) {
            R[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        long ansL = 0, ansR = 0;

        for (int i = 1; i < lenL; ++i) {
            if (i <= lenN) {
                ansL += lenN - i + 1;
            }
        }
        if (lenL <= lenN) {
//            int l = 1, r = lenN - lenL + 1, ans = 0;
//            while (l <= r) {
//                int mid = (l + r) >> 1;
//                if (check1(mid)) {
//                    ans = mid;
//                    l = mid + 1;
//                } else {
//                    r = mid - 1;
//                }
//            }
//            ansL += ans;

            int left = 1;
            int right = lenN - lenL + 2;
            while (left < right) {
                int mid = left + (right - left) / 2;
                // 边界二分 F, F,..., F, [T, T,..., T]
                // ----------------------^
                if (!check1(mid)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            ansL += left - 1;
        }

        for (int i = 1; i < lenR; ++i) {
            if (i <= lenN) {
                ansR += lenN - i + 1;
            }
        }
        if (lenR <= lenN) {
//            int l = 1, r = lenN - lenR + 1, ans = 0;
//            while (l <= r) {
//                int mid = (l + r) >> 1;
//                if (check2(mid)) {
//                    ans = mid;
//                    l = mid + 1;
//                } else {
//                    r = mid - 1;
//                }
//            }
//            ansR += ans;

            int left = 1;
            int right = lenN - lenR + 2;
            while (left < right) {
                int mid = left + (right - left) / 2;
                // 边界二分 F, F,..., F, [T, T,..., T]
                // ----------------------^
                if (!check2(mid)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            ansR += left - 1;
        }

        return String.valueOf(ansR - ansL);
    }

    static boolean check1(int x) {
        for (int i = 1; i <= lenL; ++i) {
            if (L[i] > N[x + i - 1]) return true;
            if (L[i] < N[x + i - 1]) return false;
        }
        return false;
    }

    static boolean check2(int x) {
        for (int i = 1; i <= lenR; ++i) {
            if (R[i] > N[x + i - 1]) return true;
            if (R[i] < N[x + i - 1]) return false;
        }
        return true;
    }
}
/*
超级数【算法赛】

解题思路
考察二分。
首先我们可以发现，满足差分性质。
我们假设对于大整数 X，满足小于 X 的子数个数为 F(X）。
那么对于区间 [l,r]，我们只需要算出 F(r) - F(l-1) 即可满足条件。
所以我们的问题就变成了求出满足小于等于 X 的子数个数。
首先，我们可以知道，对于位数小于 |X| 的数，一定满足条件，对于大于 |X| 的，一定不满足条件。
对于等于 |X| 的，由于 N 具有单调不减性质，所以可以二分出第一个大于 X 的位置，然后计数就好。
时间复杂度 O(|N|log|X|)
 */