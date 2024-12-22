package p1208;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CF1208B {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int left = 0;
        int right = n;
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

    static boolean checkMid(int m) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = m; i < a.length; i++) {
            int v = a[i];
            cnt.merge(v, 1, Integer::sum);
        }
        if (cnt.size() == n - m) {
            return true;
        }
        for (int i = m; i < n; i++) {
            int v = a[i];
            if (cnt.merge(v, -1, Integer::sum) == 0) {
                cnt.remove(v);
            }
            cnt.merge(a[i - m], 1, Integer::sum);
            if (cnt.size() == n - m) {
                return true;
            }
        }
        return false;
    }
}
/*
B. Uniqueness
https://codeforces.com/contest/1208/problem/B

灵茶の试炼 2024-10-08
题目大意：
输入 n(1≤n≤2000) 和长为 n 的数组 a(1≤a[i]≤1e9)。
删除 a 的一个连续子数组（可以是空的），使得剩余元素互不相同。
输出这个子数组的最短长度。
进阶：做到 O(nlogn)。

rating 1500
二分答案+滑动窗口。
用哈希表维护窗口外每个元素的出现次数。
如果哈希表大小等于窗口外的元素个数，说明窗口外的所有元素互不相同。
时间复杂度：O(nlogn)。
代码 https://codeforces.com/contest/1208/submission/283151629
======

Input
3
1 2 3
Output
0

Input
4
1 1 2 2
Output
2

Input
5
1 4 1 4 9
Output
2
 */
