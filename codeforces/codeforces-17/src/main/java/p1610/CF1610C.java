package p1610;

import java.util.Scanner;

public class CF1610C {
    static int n;
    static int[][] ab;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            ab = new int[n][2];
            for (int i = 0; i < n; i++) {
                ab[i][0] = scanner.nextInt();
                ab[i][1] = scanner.nextInt();
            }
            System.out.println(solve());
        }
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

    static boolean checkMid(int mid) {
        mid++;
        int cnt = 0;
        for (int[] p : ab) {
            int a = p[0], b = p[1];
            if (cnt <= b && mid - 1 - cnt <= a) {
                cnt++;
            }
        }
        return cnt < mid;
    }
}
/*
C. Keshi Is Throwing a Party
https://codeforces.com/contest/1610/problem/C

灵茶の试炼 2024-01-24
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) 和 n 行，每行 2 个数 a[i] 和 b[i]，范围都在 [0,n] 内。
你有 n 个朋友，第 i 个朋友有 i 元钱。
你想邀请朋友参加聚会。
对于第 i 个朋友，只有聚会中最多有 a[i] 个人比他的钱多，最多有 b[i] 个人比他的钱少，他才会参加聚会。
输出你最多可以邀请多少个人。

rating 1600
二分答案。
遍历数组，统计当前邀请了多少人。
被邀请的第一个人是谁？
如果有两个人都可以是第一个人，我们应当选更靠左的（下标更小的）。
为什么？
考虑这两个人对后续被邀请的人的影响，其实都是一样的（对于后续被邀请的人，他们只知道左边有一个人被邀请了，且这个人比他们的钱少）。
由于邀请下标更小的人，后面可以邀请的人更多，所以能邀请就直接邀请。
设当前二分的答案为 m，当前已经邀请了 cnt 个人，只要 cnt <= b[i] 且 m-1-cnt <= a[i] 就可以邀请第 i 个人。
https://codeforces.com/problemset/submission/1610/239433740
======

input
3
3
1 2
2 1
1 1
2
0 0
0 1
2
1 0
0 1
output
2
1
2
 */
