package p786;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF786C {
    private static int n;
    private static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static int clock;
    private static int[] time, ans;

    private static String solve() {
        clock = 0;
        time = new int[n + 1];
        ans = new int[n + 1];
        solve(1, n);

        ans = Arrays.copyOfRange(ans, 1, n + 1);
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }

    private static void solve(int l, int r) {
        if (l > r) {
            return;
        }
        int r1 = f(l), r2 = f(r);
        if (r1 == r2) {
            for (int i = l; i <= r; i++) {
                ans[i] = r1;
            }
            return;
        }
        ans[l] = r1;
        ans[r] = r2;
        int mid = l + (r - l) / 2;
        solve(l + 1, mid);
        solve(mid + 1, r - 1);
    }

    private static int f(int k) {
        int res = 0;
        clock++;
        int left = 0;
        for (int v : a) {
            if (time[v] == clock) {
                continue;
            }
            if (left == 0) {
                res++;
                clock++;
                left = k;
            }
            time[v] = clock;
            left--;
        }
        return res;
    }
}
/*
C. Till I Collapse
https://codeforces.com/contest/786/problem/C

灵茶の试炼 2023-05-19
题目大意：
输入 n(1≤n≤1e5) 和长为 n 的数组 a(1≤a[i]≤n)。
定义 f(k) 为最小的 m，使得存在一种将 a 划分成 m 段的方式，其中每段的不同数字个数都不超过 k。
输出 f(1), f(2), ... ,f(n)。

rating 2400
https://codeforces.com/contest/786/submission/203881564
如果所有 a[i] 都不同，那么 f(k) 的图像与 ceil(n/k) 一样，k 越大，f(k) 越小，且存在若干段连续的 k，每一段的 f(k) 都相同。进而想到，如果有相同的 a[i]，那么图像也应当是类似的。
根据这一性质，可以不去计算所有的 f(k)，而是暴力计算两个 f(i) 和 f(j)，如果 f(i) = f(j)，那么从 i+1,i+2,...,j-1 的 f 值都等于 f(i)。
如何选取 i 和 j 呢？
分治 [1,n]，让程序自动帮你选。
如果 f(i) != f(j) 就取 mid = (i+j)/2 继续分治。
计算 f(k) 直接暴力遍历+贪心，如果当前不同元素个数超过 k，就开一个新的段，重新统计。
代码实现时可以用时间戳标记，避免反复创建 vis 数组/哈希表。
时间复杂度 O(n√n)。
======

input
5
1 3 4 3 3
output
4 2 1 1 1

input
8
1 5 7 8 1 7 6 1
output
8 4 3 2 1 1 1 1
 */
