package c155;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class Abc155_d {
    static int n;
    static long k;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        k = scanner.nextLong();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        Arrays.sort(a);
        int p = searchInts(a, 0);
        int q = searchInts(a, 1);

        long neg = (long) p * (n - q);
        if (k <= neg) {
            k = neg - k + 1;
            long l = 0, r = (long) 1e18;
            while (l < r) {
                long m = l + (r - l) / 2;
                if (check1(p, q, m)) r = m;
                else l = m + 1;
            }
            long ans = -l;
            return String.valueOf(ans);
        }

        k -= neg;
        int c0 = q - p;
        long zero = (long) c0 * (n - c0) + (long) c0 * (c0 - 1) / 2;
        if (k <= zero) {
            return "0";
        }

        k -= zero;
        long l = 0, r = (long) 1e18;
        while (l < r) {
            long m = l + (r - l) / 2;
            if (check2(p, q, m)) r = m;
            else l = m + 1;
        }
        long ans = l;
        return String.valueOf(ans);
    }

    private static boolean check1(int p, int q, long kth) {
        long cnt = 0;
        int j = q;
        for (int i = 0; i < p; i++) {
            while (j < n && (long) a[j] * -a[i] <= kth) {
                j++;
            }
            cnt += j - q;
        }
        return cnt >= k;
    }

    private static boolean check2(int p, int q, long kth) {
        long cnt = 0;
        int i = 0, j = p - 1;
        while (i < j) {
            if ((long) a[i] * a[j] > kth) {
                i++;
            } else {
                cnt += j - i;
                j--;
            }
        }
        i = q;
        j = n - 1;
        while (i < j) {
            if ((long) a[i] * a[j] > kth) {
                j--;
            } else {
                cnt += j - i;
                i++;
            }
        }
        return cnt >= k;
    }

    private static int searchInts(int[] a, int key) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a[m] >= key) r = m;
            else l = m + 1;
        }
        return l;
    }
}
/*
D - Pairs
https://atcoder.jp/contests/abc155/tasks/abc155_d

灵茶の试炼 2023-09-14
题目大意：
输入 n(2≤n≤2e5) k(1≤k≤n*(n-1)/2) 和长为 n 的数组 a(-1e9≤a[i]≤1e9)。
从 a 中选两个数，相乘，一共可以得到 n*(n-1)/2 个结果。
输出这 n*(n-1)/2 个数中，第 k 小的数。
注：k=1 表示最小的数。

https://atcoder.jp/contests/abc155/submissions/45503273
说一个 O(nlogU) 的做法。U=1e18。
需要用到二分答案+同向双指针+相向双指针。
1. 对 a 从小到大排序。
2. 找到第一个 >= 0 的数的下标 p 和第一个 > 0 的数的下标 q。（下标从 0 开始）
3. 有 neg = p * (n-q) 个乘积是负数。
4. 设 c = q-p，那么有 zero = c*(n-c) + c*(c-1)/2 个乘积是 0。
5. 第一种情况：如果 k <= neg，那么答案是负数。可以二分答案的绝对值 kth，统计有多少数对相乘是负数且绝对值 <= kth，这可以用同向双指针完成。一个指针从 0 开始向右移动，另一个指针从 q 开始向右移动。
6. 第二种情况：如果 k <= neg + zero，那么答案为 0。
7. 第三种情况：如果 k > neg + zero，那么答案是正数。二分答案 kth，统计有多少个对数相乘是正数且 <= kth，这可以用相向双指针完成。对所有负数 a[i] 跑一遍相向双指针，对所有正数 a[i] 跑一遍相向双指针。
注：二分和双指针是基础中的基础，如果你写这题卡壳了或者 WA 了，说明基本功还不够扎实，请在一个月后重新做这道题。
相似题目: 2040. 两个有序数组的第 K 小乘积
https://leetcode.cn/problems/kth-smallest-product-of-two-sorted-arrays/
======

Input 1
4 3
3 3 -4 -2
Output 1
-6

Input 2
10 40
5 4 3 2 -1 0 0 0 0 0
Output 2
6
Input 3
30 413
-170202098 -268409015 537203564 983211703 21608710 -443999067 -937727165 -97596546 -372334013 398994917 -972141167 798607104 -949068442 -959948616 37909651 0 886627544 -20098238 0 -948955241 0 -214720580 277222296 -18897162 834475626 0 -425610555 110117526 663621752 0
Output 3
448283280358331064
 */