package p1582;

import java.util.Scanner;

public class CF1582E {
    static int n;
    static long[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new long[n + 1];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        long[] suf = new long[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            suf[i] = Math.max(suf[i + 1], a[i]);
            a[i] += a[i + 1];
        }

        long[] suf2 = new long[n];
        int k = 2;
        for (int L = n - 1; L >= k; L -= k - 1) {
            suf2[L - k + 1] = 0;
            for (int i = L - k; i >= 0; i--) {
                long s = a[i] - a[i + k];
                if (suf2[i + 1] < s && s < suf[i + k]) {
                    suf2[i] = s;
                } else {
                    suf2[i] = suf2[i + 1];
                }
            }

            if (suf2[0] == 0) {
                break;
            }
            // suf, suf2 = suf2, suf
//            long[] tmp = suf.clone();
//            suf = suf2.clone();
//            suf2 = tmp;
            suf = suf2.clone();
            suf2 = new long[n];

            k++;
        }
        return String.valueOf(k - 1);
    }
}
/*
E. Pchelyonok and Segments
https://codeforces.com/contest/1582/problem/E

灵茶の试炼 2022-08-10
题目大意：
如果你没有做昨天的题，推荐先做昨天的，再做这道，会简单一些。
输入 t(t≤100) 表示 t 组数据。
每组数据输入 n(1≤n≤1e5) 和长为 n 的整数数组 a (1≤a[i]≤1e9)，所有数据的 n 之和不超过 1e5。
从 a 中选尽可能多的互不相交的子数组，设有 k 个子数组，需满足：
1. 从左到右第一个子数组的长度恰好是 k，第二个的长度恰好是 k-1，……，最后一个的长度恰好是 1；
2. 从左到右第 i 个子数组的元素和严格小于第 i+1 个子数组的元素和。
输出 k 的最大值。
注：子数组是连续的。

rating 2000
https://codeforces.com/contest/1582/submission/165737186
提示 1：k 至多是多少？
提示 2：从右往左思考。
提示 3-1：思考如何从 k-1 递推到 k，我们需要计算什么？
提示 3-2：贪心地想，后面的子数组的元素和越大，我们越能在剩余数字中选出更多的子数组。因此我们需要计算最左边的子数组的最大值。
具体来说，定义 suf[k][i] 表示从 a[i:] 中选择 k 个子数组，其中最左边的子数组的元素和的最大值（不存在时 suf[k][i] = 0）。
考虑 a[i] 选 or 不选，取 max：
不选就是 suf[k][i] = suf[k][i+1]。
选就要满足题目的约束，即 suf[k][i] = a[i]+...+a[i+k-1] (用后缀和优化，记作 s)，需满足 s < suf[k-1][i+k]。
不断增大 k，当剩余长度不足 k 或者 suf[k][0] = 0 时退出循环。
代码实现中可以用两个数组滚动优化掉第一个维度。
======

input
5
1
1
3
1 2 3
5
1 1 2 2 3
7
1 2 1 1 3 2 6
5
9 6 7 9 7
output
1
1
2
3
1
 */
