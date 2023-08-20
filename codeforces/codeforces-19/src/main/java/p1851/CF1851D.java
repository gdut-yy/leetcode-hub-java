package p1851;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF1851D {
    static int n;
    static long[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new long[n];
            for (int i = 1; i < n; i++) {
                a[i] = scanner.nextLong();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        boolean[] has = new boolean[n + 1];
        int cnt = n;
        List<Long> mismatch = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (a[i] - a[i - 1] <= n) {
                int delta = (int) (a[i] - a[i - 1]);
                if (!has[delta]) {
                    has[delta] = true;
                    cnt--;
                } else {
                    mismatch.add(a[i] - a[i - 1]);
                }
            } else {
                mismatch.add(a[i] - a[i - 1]);
            }
        }

        // 无解：缺超过两个数
        if (mismatch.size() > 1 || cnt > 2) {
            return "NO";
        }

        // 仅缺一个数
        if (cnt == 1) {
            return "YES";
        }
        // 缺两个数
        long sum = 0;
        for (int x = 1; x <= n; x++) {
            if (!has[x]) {
                sum += x;
            }
        }
        for (Long x : mismatch) {
            sum -= x;
        }
        return sum == 0 ? "YES" : "NO";
    }
}
/*
D. Prefix Permutation Sums
https://codeforces.com/contest/1851/problem/D

题目大意：
你的朋友有一个 n 个元素的数组，计算了它的前缀和数组并传递给你，在传输过程中意外地丢失了一个元素。你的任务是找出给定的数组是否可以匹配排列。
n 个元素的排列是一个从 1 到 n 的 n 个数字的数组，每个数字在其中恰好出现一次。
数组 a -的前缀和数组是这样一个数组 b，即 bi=∑ij=1aj,1≤i≤n。
例如，原始排列为[1,5,2,4,3]。它的前缀和数组-[1,6,8,12,15]。丢失一个元素后，可以得到数组[6,8,12,15]或[1,6,8,15]。
也可以证明数组[1,2,100]不对应于任何排列。

分类讨论。
仅缺一个数：
缺两个数：
其他情况：无解
======

input
12
5
6 8 12 15
5
1 6 8 15
4
1 2 100
4
1 3 6
2
2
3
1 2
4
3 7 10
5
5 44 46 50
4
1 9 10
5
13 21 36 42
5
1 2 3 1000000000000000000
9
9 11 12 20 25 28 30 33
output
YES
YES
NO
YES
YES
NO
YES
NO
NO
NO
NO
NO
 */
