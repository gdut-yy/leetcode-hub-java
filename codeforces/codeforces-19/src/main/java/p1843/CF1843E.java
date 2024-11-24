package p1843;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1843E {
    static int n, m, q;
    static int[][] lr;
    static int[] x;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            lr = new int[m][2];
            for (int i = 0; i < m; i++) {
                lr[i][0] = scanner.nextInt();
                lr[i][1] = scanner.nextInt();
            }
            q = scanner.nextInt();
            x = new int[q];
            for (int i = 0; i < q; i++) {
                x[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        int left = 0;
        int right = q + 1;
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
        int ans = left == q + 1 ? -1 : left;
        return String.valueOf(ans);
    }

    private static boolean checkMid(int mid) {
        int[] nums = new int[n];
        for (int i = 0; i < mid; i++) {
            nums[x[i] - 1]++;
        }
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        for (int[] p : lr) {
            int l = p[0], r = p[1];
            int ones = preSum[r] - preSum[l - 1];
            int zeros = (r - l + 1) - ones;
            if (ones > zeros) {
                return true;
            }
        }
        return false;
    }
}
/*
E. Tracking Segments
https://codeforces.com/contest/1843/problem/E

灵茶の试炼 2024-05-29
题目大意：
给定一个由 n 个 0 组成的数组。你也得到了 m 个不一定不同的线段。每个段由两个数字 li 和 ri(1≤li≤ri≤n)定义，表示数组 a 的子数组 ali,ali+1,...,ari。
我们称这段为 li,ri 如果这段上 1 的个数严格大于 0 的个数。例如，如果 a=[1,0,1,0,1]，则段[1,5]是美丽的(1 的个数是 3,0 的个数是 2)，但段[3,4]不是美丽的(1 的个数是 1,0 的个数是 1)。
还有 q 个变化量。对于每一个变化，你都得到一个数字 1≤x≤n，这意味着你必须给一个元素 ax 赋值 1。
您必须找到 m 个给定片段中至少有一个变得美丽的第一个变化，或者在处理所有 q 个变化后报告它们都不美丽。

rating 1600
二分答案 + 前缀和
======

input
6
5 5
1 2
4 5
1 5
1 3
2 4
5
5
3
1
2
4
4 2
1 1
4 4
2
2
3
5 2
1 5
1 5
4
2
1
3
4
5 2
1 5
1 3
5
4
1
2
3
5
5 5
1 5
1 5
1 5
1 5
1 4
3
1
4
3
3 2
2 2
1 3
3
2
3
1
output
3
-1
3
3
3
1
 */
