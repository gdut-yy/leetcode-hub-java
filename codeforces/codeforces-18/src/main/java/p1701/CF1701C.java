package p1701;

import java.util.Scanner;

public class CF1701C {
    static int n, m;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            a = new int[m];
            for (int i = 0; i < m; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        int[] cnt = new int[n];
        for (int v : a) {
            cnt[v - 1]++;
        }

        int left = 0;
        int right = m * 2;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(cnt, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return String.valueOf(left);
    }

    private static boolean checkMid(int[] cnt, int t) {
        long ex = 0;
        for (int c : cnt) {
            if (c > t) {
                ex += c - t;
            } else {
                ex -= (t - c) / 2;
            }
        }
        return ex <= 0;
    }
}
/*
C. Schedule Management
https://codeforces.com/contest/1701/problem/C

灵茶の试炼 2024-01-15
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 m 之和 ≤2e5。
每组数据输入 n m(1≤n≤m≤2e5) 和长为 m 的数组 a(1≤a[i]≤n)。
有 n 名工人和 m 个任务，a[i] 表示擅长第 i 个任务的工人编号。
每个任务只能分配给一名工人。如果工人擅长该任务，他会用 1 小时完成，否则需要 2 小时完成。
一名工人一次只能做一个任务，完成一个任务后，才能开始他的下一个任务。
所有工人同时开始工作。
输出完成所有任务最少要多少小时。

rating 1400
先预处理每名工人擅长多少个任务，记到 cnt 数组中。
二分答案 t。
如果 cnt[i] > t，那么这名工人只能用 t 时间做 t 个他最擅长的任务。多出的 cnt[i]-t 个任务加到 ex 中，表示多出的任务个数。
如果 cnt[i] <= t，那么这名工人可以用余下的时间做 (t-cnt[i])/2 个他不擅长的任务，从 ex 中减去 (t-cnt[i])/2。
最后如果 ex > 0，说明 t 小了，增大二分下界，否则减小二分上界。
https://codeforces.com/contest/1701/submission/239144035
======

input
4
2 4
1 2 1 2
2 4
1 1 1 1
5 5
5 1 3 2 4
1 1
1
output
2
3
1
1
 */
