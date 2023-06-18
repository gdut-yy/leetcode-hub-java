package p883;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF883I {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            v[i] = scanner.nextInt();
        }
        System.out.println(solve(n, k, v));
    }

    private static String solve(int n, int k, int[] a) {
        Arrays.sort(a);

        int left = 0;
        int right = a[n - 1] - a[0];
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(n, k, a, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return String.valueOf(left);
    }

    private static boolean checkMid(int n, int k, int[] a, int mx) {
        boolean[] f = new boolean[n + 1];
        f[0] = true;
        int j0 = 0;
        for (int i = k - 1; i < n; i++) {
            while (a[i] - a[j0] > mx) {
                j0++;
            }
            while (j0 <= i - k + 1) {
                if (f[j0]) {
                    f[i + 1] = true;
                    break;
                }
                j0++;
            }
        }
        return f[n];
    }
}
/*
I. Photo Processing
https://codeforces.com/contest/883/problem/I

灵茶の试炼 2023-05-11
题目大意：
输入 n k(1≤k≤n≤3e5) 和长为 n 的数组 a(1≤a[i]≤1e9)。
把这 n 个数重新排列，然后分成若干个组，要求每组至少有 k 个数。
定义 diff(b) 表示序列 b 中最大值与最小值的差。
计算所有组的 diff 值的最大值 mx。
输出 mx 的最小值。

https://codeforces.com/problemset/submission/883/205379777
排序后，二分答案。
贪心分组？看上去漏洞百出，不妨考虑 DP。
定义 f[i+1] 表示 a[0] 到 a[i] 能否满足要求。
初始值 f[0]=true，表示空数组满足要求。
先写一个 O(n^2) 的转移，也就是 f[i+1] = any(f[j])，这里 i-j+1 >= k 且 a[i]-a[j]<=mx，any(f[j]) 表示只要有一个 f[j] 是 true，f[i+1] 就是 true。
相当于，如果 a[0] 到 a[j-1] 满足要求，且 a[j] 到 a[i] 满足要求，那么 f[i+1] 就是 true。
如何优化？
设 f[i+1] 是从 f[j0] 转移过来的，这里 j0 满足 f[j0]=true。
那么 f[i+2] 可以从 >= j0 的下标转移过来，因为有 j0 的存在，且随着 i 的增大，j 能取到的最小值不会减少（因为 a[i]-a[j]<=mx），所以 j<j0 的 f[j] 就无需考虑了。
既然 j0 是单调递增的，利用这个性质就可以用双指针把 check 优化到 O(n)。
======

input
5 2
50 110 130 40 120
output
20

input
4 1
2 3 4 1
output
0
 */
